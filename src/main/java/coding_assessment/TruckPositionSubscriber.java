package coding_assessment;

import java.text.DecimalFormat;
import java.util.*;

public class TruckPositionSubscriber {
    /**
     * A logistics company has a central software solution to track the
     * position of their trucks. Different applications are interested in
     * different trucks. To save bandwidth the company wants to have a
     * central subscriber for each local office. This service will then be used
     * by the applications in the office to get position updates.
     * Your task is to implement the Subscriber class. The subscriber can
     * request information from the central server by providing the ID for a
     * truck. The server will return the current position and will afterwards
     * send position updates as differences as they become available.
     * When a client subscribes to a truck the subscriber should return the
     * current truck position. Additionally, the client can request an update.
     * In that case the client should receive all the updates for all trucks
     * since it last requested an update. It is important that all updates
     * arrive in the same order as they were initially sent out. Truck
     * positions are represented in x and y coordinates.
     */
    public class TruckPosition {
        public double mX;
        public double mY;
    }

    public class TruckPositionDelta {
        public int mTruckId;
        public double mDeltaX;
        public double mDeltaY;
        @Override
        public String toString() {
            return mTruckId + " " + mDeltaX + " " + mDeltaY;
        }
    }

    public interface IServer {
        public TruckPosition SubscribeToTruck(int truckId);
    }

    public interface ISubscriber {
        // Called by server after initial subscription
        public void ProcessUpdate(final TruckPositionDelta positionDelta);

        // Called by clients
        public TruckPosition SubscribeToTruck(int truckId, int clientId);
        public List<TruckPositionDelta> GetUpdates(int clientId);
    }

    class Subscriber implements ISubscriber {
        private final IServer mServer;
        List<TruckPositionDelta> updateList;
        Map<Integer, List<Integer>> subscribedClient;
        public Subscriber(IServer server) {
            mServer = server;
            updateList = new ArrayList();
            subscribedClient = new HashMap<>();
        }

        @Override
        public void ProcessUpdate(final TruckPositionDelta positionDelta) {
            updateList.add(positionDelta);
        }

        @Override
        public TruckPosition SubscribeToTruck(int truckId, int clientId) {
            if (subscribedClient.containsKey(clientId)) {
                subscribedClient.get(clientId).add(truckId);
            } else {
                List<Integer> li = new ArrayList();
                li.add(truckId);
                subscribedClient.put(clientId, li);
            }
            return mServer.SubscribeToTruck(truckId);
        }

        @Override
        public List<TruckPositionDelta> GetUpdates(int clientId) {
            List<TruckPositionDelta> result = new ArrayList();
            int listSize = updateList.size();
            List<TruckPositionDelta> newList = new ArrayList<>();
            for (int i = 0; i < listSize; i++) {
                TruckPositionDelta pos = updateList.get(i);
                boolean added = false;
                for (int truckId : subscribedClient.get(clientId)) {
                    if (pos.mTruckId == truckId) {
                        result.add(pos);
                        added = true;
                    }
                }
                if (!added) newList.add(pos);
            }
            updateList = newList;
            return result;
        }}

    class Server implements IServer {
        private HashSet<Integer> mRegisteredTrucks;
        private HashMap<Integer, TruckPosition> mCurrentPos;


        public Server() {
            mRegisteredTrucks = new HashSet<>();
            mCurrentPos = new HashMap<>();
        }

        @Override
        public TruckPosition SubscribeToTruck(int truckId) {
            mRegisteredTrucks.add(truckId);
            TruckPosition pos = mCurrentPos.get(truckId);
            TruckPosition copy = new TruckPosition();
            copy.mX = pos.mX;
            copy.mY = pos.mY;
            return copy;
        }

        public void AddPosition(int truckId, TruckPosition pos) {
            mCurrentPos.put(truckId, pos);
        }

        public void OnUpdate(Subscriber subscriber, final TruckPositionDelta delta) {
            if (mRegisteredTrucks.contains(delta.mTruckId))
            {
                subscriber.ProcessUpdate(delta);
            }
            TruckPosition pos = mCurrentPos.get(delta.mTruckId);
            pos.mX += delta.mDeltaX;
            pos.mY += delta.mDeltaY;
        }
    }

    class Client {
        private final int mClientId;
        private final Subscriber mSubscriber;
        private final DecimalFormat mFormat;

        public Client(int clientId, Subscriber subscriber) {
            mClientId = clientId;
            mSubscriber = subscriber;
            mFormat = new DecimalFormat("0.#");
        }

        public void Subscribe(int truckId) {
            TruckPosition pos = mSubscriber.SubscribeToTruck(truckId, mClientId);
            System.out.println("S " + mClientId + " " + truckId + " " + mFormat.format(pos.mX) + " " + mFormat.format(pos.mY));
        }

        public void RequestUpdate() {
            List<TruckPositionDelta> updates = mSubscriber.GetUpdates(mClientId);
            for (final TruckPositionDelta delta : updates) {
                System.out.println("U " + mClientId + " " + delta.mTruckId + " " + mFormat.format(delta.mDeltaX) + " " + mFormat.format(delta.mDeltaY));
            }
        }
    }

    public static void main(String[] args) {
        TruckPositionSubscriber solution = new TruckPositionSubscriber();
        Server server = solution.new Server();
        Subscriber subscriber = solution.new Subscriber(server);
        List<Client> clients = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        int numTrucks = scanner.nextInt();
        for (int i = 0; i < numTrucks; i++) {
            TruckPosition pos = solution.new TruckPosition();
            pos.mX = scanner.nextDouble();
            pos.mY = scanner.nextDouble();
            server.AddPosition(i, pos);
        }

        while (scanner.hasNext()) {
            char command = scanner.next().charAt(0);
            if (command == 'S') {
                int clientId = scanner.nextInt();
                if (clientId >= clients.size()) {
                    clients.add(solution.new Client(clientId, subscriber));
                }
                clients.get(clientId).Subscribe(scanner.nextInt());
            } else if (command == 'U') {
                TruckPositionDelta delta = solution.new TruckPositionDelta();
                delta.mTruckId = scanner.nextInt();
                delta.mDeltaX = scanner.nextDouble();
                delta.mDeltaY = scanner.nextDouble();
                server.OnUpdate(subscriber, delta);
            } else if (command == 'R') {
                int clientId = scanner.nextInt();
                clients.get(clientId).RequestUpdate();
            } else {
                throw new IllegalArgumentException("Invalid input");
            }
        }
    }
}

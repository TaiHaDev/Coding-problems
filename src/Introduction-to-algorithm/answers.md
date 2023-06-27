## Exercise answers (deprecated)
This part includes answers to exercises in the Introduction to Algorithms book by MIT press that I encountered.


[#### Heapsort
6.1-1. What are the minimum and maximum numbers of elements in a heap of
height h?
- maximum: 2^(h+1) - 1 (full element in tree), minimum: 2^(h) (only one element on the last level).

6.1-2. Show that an n-element heap has height ⌊lg n⌊.
- Write n = 2m −1+k where m is as large as possible. Then the heap consists
  of a complete binary tree of height m − 1, along with k additional leaves along
  the bottom. The height of the root is the length of the longest simple path to
  one of these k leaves, which must have length m. It is clear from the way we
  defined m that m = ⌊logn⌊. (from online solution)

6.1-3.
  Show that in any subtree of a max-heap, the root of the subtree contains
  the largest value occurring anywhere in that subtree.
- If the root of the subtree doesn't contain the largest value, it will violate the property of
the heap as that root will have a child that is bigger than itself.
6.1-4.
  Where in a max-heap might the smallest element reside, assuming that
  all elements are distinct?
- At the lowest level (one of the leaf node) because if not, it will violate the property
of the max heap, a node must have its children smaller than itself, therefore it can only be the leaf node.
  6.1-5.
  At which levels in a max-heap might the kth largest element reside, for 2
  ≤ k ≤ ⌊n/2⌊, assuming that all elements are distinct?
- (to be verified), the kth largest element can be at level ranging from 1 to log(k)
  6.1-6.
  Is an array that is in sorted order a min-heap?
- Yes, because when we actually construct the heap, the children would always be bigger than its parent.
  6.1-7.
  Is the array with values 〈33, 19, 20, 15, 13, 10, 2, 13, 16, 12〉 a max-heap?
- No, because 16 is the child of 15 node but 16 is greater than 15
  6.1-8.
  Show that, with the array representation for storing an n-element heap,
  the leaves are the nodes indexed by ⌊n/2⌊ + 1, ⌊n/2⌊ + 2, … , n.
-  compute the left node of [n/2] + 1, we found out that the index is larger than the total element
of the heap, therefore that node is indeed a leaf node. We can concl]()ude than any node indexed by [n/2] + 1 forward is a leaf node.
# 580 - Algorithms Assignment 1

## Algorithm Design - MinPriorityQueue add(T elem)
We implemented the adding function for the MinPriorityQueue using one
base cases and one recursive call. The base case for the adding
function is if the parent was a root node. We passed the elements that
are added to the queue by comparing them to the element at
location/2. If the result of this comparison is greater or equal to
0, the elements are swapped in the array and the recursion is called
with location/2.

Note that we used a separate recursive helper function for this
operation. The main function resizes the data structure accordingly if
adding the new element requires a greater array. 


## Algorithm Design - MinPriorityQueue remove
To remove an element, the root node of the tree is removed and then
one of the lower leaves is moved to that location before sorting. In
order to sort the tree the root node (the previous leaf node) is
compared to its children, if it is a smaller (a higher priority node)
than both its children then no further action is taken. If however it
is a larger (lower priority event), the smallest child node (highest
priority child node) is swapped with it. This process continues until
the tree is fully sorted.

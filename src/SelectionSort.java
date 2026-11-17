/**
 * =====================================================================
 *  DAY 1  -  SELECTION SORT
 * =====================================================================
 *
 *  THE IDEA
 *  Look through the whole list and find the SMALLEST item. Swap it into
 *  position 0. Now look through the rest of the list (positions 1 to the end),
 *  find the smallest, and swap it into position 1. Keep going until the
 *  whole list is sorted.
 *
 *  TOOLS (see SortArray.java for the full list)
 *      arr.size()        number of items
 *      arr.less(i, j)    true if a[i] < a[j]      (counts as a comparison)
 *      arr.swap(i, j)    swap a[i] and a[j]       (counts as a swap)
 *
 *  RULE: never compare or move items any other way - use arr's methods so
 *        the visualizer can count and animate your work.
 *
 *  ANALYSIS QUESTIONS (try them in the visualizer!)
 *   1. For n = 10, 20, 40 items, how many comparisons does selection sort make?
 *      Does it change if the data is already sorted? Reversed?
 *   2. What is the MOST swaps it can ever make for n items?
 */
public class SelectionSort implements SortAlgorithm {

    @Override
    public String getName() { return "Selection Sort"; }


    @Override
    public void sort(SortArray arr) {
        for (int i = 0; i < arr.size()-1; ++i) {
            int minIdx = i;
            for (int j = i+1; j < arr.size(); ++j) {
                if (arr.less(j, minIdx)) minIdx = j;
            }
            arr.swap(i, minIdx);
            arr.mark("i=" + i + " min=" + minIdx);
        }
    }
}

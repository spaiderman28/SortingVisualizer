/**
 * =====================================================================
 *  DAY 1  -  INSERTION SORT
 * =====================================================================
 *
 *  THE IDEA
 *  Think of sorting a hand of cards. The left part of the list is "sorted so
 *  far". Take the next item and slide it LEFT until the item before it is not
 *  bigger than it. Then move on to the next item. Repeat until you've handled
 *  every item.
 *
 *  TWO WAYS TO DO THE SLIDING (try both and compare the counts!)
 *   A) Swap it left one spot at a time:   arr.less(j, j - 1)  then  arr.swap(j, j - 1)
 *   B) "Hold" the item and shift bigger items right:
 *          Item key = arr.get(i);              // pick it up (free)
 *          arr.less(key, j)                    // is the held key < a[j]?
 *          arr.set(j + 1, arr.get(j));         // shift a[j] right one spot (a write)
 *          arr.set(spot, key);                 // drop the key in its place (a write)
 *
 *  TOOLS: arr.size(), arr.less(...), arr.swap(...), arr.get(...), arr.set(...)
 *
 *  ANALYSIS QUESTIONS
 *   1. Compare insertion sort on "Already sorted", "Random" and "Reversed" data.
 *      Which case is best? Which is worst? Why?
 *   2. Try "Few unique values". Is your insertion sort STABLE? (The result line tells you.)
 *   3. Insertion vs. selection: which does fewer comparisons on "Nearly sorted" data?
 */
public class InsertionSort implements SortAlgorithm {

    @Override
    public String getName() { return "Insertion Sort"; }



    @Override
    public void sort(SortArray arr) {
        for (int i = 1; i < arr.size(); ++i) {
            for (int j = i-1; j >= 0; --j) {
                if (arr.less(j+1,j)) arr.swap(j+1,j);
            }
            arr.mark("i=" + i);
        }
    }

}

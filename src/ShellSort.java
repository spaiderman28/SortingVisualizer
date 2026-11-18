/**
 * =====================================================================
 *  DAY 2  -  SHELL SORT
 * =====================================================================
 *
 *  THE IDEA
 *  Insertion sort is slow when an item has to travel a long way, because it
 *  only moves one spot at a time. Shell sort fixes that: first do an insertion
 *  sort on items that are h spots apart (a "gap" of h), so items can jump far.
 *  Then shrink the gap and do it again. The last pass uses a gap of 1, which is
 *  just a normal insertion sort - but by then the list is nearly sorted, so
 *  it's fast.
 *
 *  GAP SEQUENCE (Knuth's): 1, 4, 13, 40, 121, ...   (h = 3*h + 1)
 *   - Start with the largest gap that is less than n / 3.
 *   - After each pass, go to the next smaller gap:  h = h / 3
 *
 *  HINT: Take your insertion sort from Day 1. Everywhere it uses "1"
 *        (j - 1, compare with the item 1 spot to the left), use "h" instead.
 *
 *  TOOLS: arr.size(), arr.less(...), arr.swap(...), arr.get(...), arr.set(...)
 *
 *  ANALYSIS QUESTIONS
 *   1. Run insertion sort and shell sort on the same Random data with n = 50 and 100.
 *      How do the comparison counts compare?
 *   2. Try a different gap sequence (e.g. n/2, n/4, ..., 1). Is it better or worse?
 *   3. Is shell sort stable? Test with "Few unique values".
 */
public class ShellSort implements SortAlgorithm {

    @Override
    public String getName() { return "Shell Sort"; }

    @Override
    public void sort(SortArray arr) {
        // TODO: write shell sort here
        int h =1, n = arr.size();
        while (h < n/3) h = 3*h+1;

        while (h >= 1) {
            for (int i = 0; i < h; ++i) {
                for (int j = i+h; j < n; j += h) {
                    int index = j;
                    while (index >= h) {
                        if (arr.less(index, index-h)) {
                            arr.swap(index, index-h);
                            index -= h;
                        }
                        else break;
                    }
                }
            }
            h /= 3;
        }
    }
}

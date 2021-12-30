import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * PaginationHelperTest.java - This is a class used to test the functions defined in PaginationHelper.java
 *
 * @author Tetiana Kravchuk
 */

public class PaginationHelperTest {

    static PaginationHelper paginationHelper1;
    static PaginationHelper paginationHelper2;
    static PaginationHelper paginationHelper3;
    static PaginationHelper paginationHelper4;
    static PaginationHelper paginationHelper5;
    static PaginationHelper paginationHelper6;
    static PaginationHelper paginationHelper7;


    @Test
    @DisplayName("Counts total quantity of given items.")
    public void testItemCount() {
        paginationHelper1 = new PaginationHelper(new Object[]{'a', 'b', 'c', 'd', 'e', 'f'}, 6);
        paginationHelper1.itemCount();
        assertEquals(6, paginationHelper1.itemCount(), "Total given items count is incorrect: ");
        paginationHelper2 = new PaginationHelper(new Object[]{4, 5, "srk"}, 3);
        paginationHelper2.itemCount();
        assertEquals(3, paginationHelper2.itemCount(), "Total given items count is incorrect: ");
        paginationHelper3 = new PaginationHelper(new Object[]{"srk"}, 1);
        paginationHelper3.itemCount();
        assertEquals(1, paginationHelper3.itemCount(), "Total given items count is incorrect: ");
        paginationHelper4 = new PaginationHelper(new Object[]
                {'a', 'b', 'c', 'd', 'e', 'f', 3, 5, 6, "#", 4.5,}, 5);
        paginationHelper4.itemCount();
        assertEquals(11, paginationHelper4.itemCount(), "Total given items count is incorrect: ");
        paginationHelper5 = new PaginationHelper(new Object[]{}, 5);
        paginationHelper5.itemCount();
        assertEquals(0, paginationHelper5.itemCount(), "Total given items count is incorrect: ");
        paginationHelper6 = new PaginationHelper(new Object[]{}, 5);
        paginationHelper6.itemCount();
        assertEquals(0, paginationHelper6.itemCount(), "Total given items count is incorrect: ");
        paginationHelper7 = new PaginationHelper(new Object[]{-9, -0, 0, -1, 9, 0}, 5);
        paginationHelper7.itemCount();
        assertEquals(6, paginationHelper7.itemCount(), "Total given items count is incorrect: ");


    }

    @ParameterizedTest
    @DisplayName("Returns page index with given item index. If ItemIndex or PageIndex is invalid returns -1.")
    @CsvSource({"10,2", "5,1", "0,0", "20,-1", "15, -1", "-1,-1"})
    public void testPageIndexWithGivenItemsPerPage(int itemIndex, int pageIndex) {
        paginationHelper1 = new PaginationHelper(new Object[]
                {'a', 'b', 'c', 'd', 'e', 3, 4, 5, 'l', 'm', 'n', 'o'}, 4);
        assertEquals(pageIndex, paginationHelper1.pageIndex(itemIndex),
                "Page Index of given item index is incorrect: " +
                        itemIndex + " :");
    }

    @ParameterizedTest
    @DisplayName("Counts quantity of items on the given page index. If PageIndex is invalid returns -1.")
    @CsvSource({"2,2", "1,5", "0,5", "-1,-1", "24, -1", "8,-1", "105,-1"})
    public void testPageItemCountWithGivenPageIndex(int pageIndex, int expectedItemCount) {
        paginationHelper1 = new PaginationHelper(new Object[]
                {1, 2, 3, 1, 2, 3, 4, 5, "srk", "gg", "dd", 3}, 5);
        assertEquals(expectedItemCount, paginationHelper1.pageItemCount(pageIndex),
                "Quantity of items on the given page index is incorrect: " +
                        pageIndex + " :");
    }

    @ParameterizedTest
    @CsvSource({"5,2", "3,4", "4,3", "0,0", "-1, 0", "-20,0"})
    @DisplayName("Counts total page quantity with given number of " +
            "items per page. If ItemsPerPage is invalid returns 0.")
    public void testPageCount(int itemsPerPage, int expectedPageCount) {
        paginationHelper1 = new PaginationHelper(new Object[]{'a', 'b', 4, 5, 6, 'd', 'e', 'a', 'b', 5}, itemsPerPage);
        assertEquals(expectedPageCount, paginationHelper1.pageCount(),
                "Total Page Count for " + paginationHelper1.itemCount() + " items is incorrect, " +
                        paginationHelper1.itemsPerPage + " items per page");
    }
}


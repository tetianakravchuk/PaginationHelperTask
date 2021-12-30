public class PaginationHelper {
    /**
     * PaginationHelper class implements pagination of UI components
     */
    Object[] itemsArr;
    int itemsPerPage;

    /**
     * @param itemsArr     array of items
     * @param itemsPerPage quantity of items on the one page
     */
    public PaginationHelper(Object[] itemsArr, int itemsPerPage) {
        this.itemsArr = itemsArr;
        this.itemsPerPage = itemsPerPage;
    }

    /**
     * method returns total quantity of items in UI
     *
     * @return total items quantity
     */
    public int itemCount() {
        return itemsArr.length;
    }

    /**
     * method reruns total pages quantity in UI
     *
     * @return total pages quantity
     */
    public int pageCount() {
        if (itemsPerPage <= 0) {
            return 0;
        }
        double temp = Math.ceil((double) itemsArr.length / itemsPerPage);
        int pagesQuantity;
        if (temp == temp) {
            pagesQuantity = (int) temp;
        } else {
            pagesQuantity = (int) (temp + 1);
        }
        return pagesQuantity;
    }

    /**
     * method returns index of page by index of item in the array of items
     *
     * @param itemIndex index of item in the array of items
     * @return index of page
     */
    public int pageIndex(int itemIndex) {
        int pageIndexNumber = 0;
        if (itemIndex < 0 || itemIndex >= itemCount() || itemsPerPage <= 0) {
            return -1;
        }
        pageIndexNumber = (int) Math.ceil(itemIndex / itemsPerPage);
        return pageIndexNumber;
    }

    /**
     * method returns quantity of items on the specified page index
     *
     * @param pageIndex page index in UI
     * @return quantity of items on the specified page index
     */
    public int pageItemCount(int pageIndex) {
        if (pageIndex < 0 || pageIndex > pageCount()) {
            return -1;
        }
        int temp = itemsArr.length / itemsPerPage;
        int itemsNumber;
        if (pageIndex + 1 <= temp) {
            itemsNumber = itemsPerPage;
        } else {
            itemsNumber = itemsArr.length - (int) temp * itemsPerPage;
        }
        return itemsNumber;
    }
}


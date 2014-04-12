package cs102.program.serendipity.bookstore;

/**
 * Created by Subrina on 1/30/14.
 */
public class BookInfo {

    private String isbn, title, author, publisher, dateAdded;
    private int quantity;
    private double wholesaleCost, retailPrice;

    public BookInfo() {
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(String dateAdded) {
        this.dateAdded = dateAdded;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getWholesaleCost() {
        return wholesaleCost;
    }

    public void setWholesaleCost(double wholesaleCost) {
        this.wholesaleCost = wholesaleCost;
    }

    public double getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(double retailPrice) {
        this.retailPrice = retailPrice;
    }

    public static String getBooksHeader() {
        StringBuilder output = new StringBuilder();

        output.append(String.format("|%20s|%30s|%20s|%12s|%10s|%15s|%10s|", "ISBN", "Title", "Publisher", "Date Added", "Quantity", "Wholesale Cost", "Retail Price"));
        output.append("\n-------------------------------------------------------------------------------------------------------------------------------\n");

        return output.toString();
    }

    @Override
    public String toString() {

        StringBuilder output = new StringBuilder();
//        String val = title;
//        if(title.length() > 30){
//        StringBuilder sb = new StringBuilder(title);
//        int i = 0;
//        while ((i = sb.indexOf(" ", i + 20)) != -1) {
//            sb.replace(i, i + 1, "|\n| ");
//        }
//
//            val = String.format("%s%40s", "", sb.toString());
//            output.append(String.format("|%20s|%30s|%20s|%12s|%10d|%15.2f|%12.2f|", isbn, val, publisher, dateAdded, quantity, wholesaleCost, retailPrice));
//        }else {
        
        output.append(String.format("|%20s|%30s|%20s|%12s|%10d|%15.2f|%12.2f|", isbn, title, publisher, dateAdded, quantity, wholesaleCost, retailPrice));
//        }

        
        return output.toString();
    }
}

public class TourPackage implements Comparable<TourPackage> {
    private int packageID;
    private String destination;
    private double price;

    public TourPackage(int packageID, String destination, double price) {
        this.packageID = packageID;
        this.destination = destination;
        this.price = price;
    }

    public int getPackageID() {
        return packageID;
    }

    public void setPackageID(int packageID) {
        this.packageID = packageID;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public int compareTo(TourPackage other) {
        return this.destination.compareTo(other.destination);
    }

    @Override
    public String toString() {
        return "TourPackage [packageID=" + packageID + ", destination=" + destination + ", price=" + price + "]";
    }
}
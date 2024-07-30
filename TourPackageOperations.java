import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TourPackageOperations {

    private List<TourPackage> tourPackages;

    public TourPackageOperations() {
        tourPackages = new ArrayList<>();
    }

    public void addTourPackage(TourPackage tourPackage) {
        tourPackages.add(tourPackage);
    }

    public void sortByDestination() {
        Collections.sort(tourPackages);
    }

    public void sortByPrice() {
        tourPackages.sort(new Comparator<TourPackage>() {
            @Override
            public int compare(TourPackage tp1, TourPackage tp2) {
                return Double.compare(tp1.getPrice(), tp2.getPrice());
            }
        });
    }

    public void displayTourPackages() {
        for (TourPackage tp : tourPackages) {
            System.out.println(tp);
        }
    }

    public static void main(String[] args) {
        TourPackageOperations operations = new TourPackageOperations();

        operations.addTourPackage(new TourPackage(1, "Paris", 1200.50));
        operations.addTourPackage(new TourPackage(2, "New York", 950.00));
        operations.addTourPackage(new TourPackage(3, "Tokyo", 1100.75));
        operations.addTourPackage(new TourPackage(4, "Sydney", 1050.00));

        System.out.println("Unsorted Tour Packages:");
        operations.displayTourPackages();

        operations.sortByDestination();
        System.out.println("\nTour Packages Sorted by Destination:");
        operations.displayTourPackages();

        operations.sortByPrice();
        System.out.println("\nTour Packages Sorted by Price:");
        operations.displayTourPackages();
    }
}
package org.example.lesson_5;

import lombok.Data;

import java.util.ArrayList;

@Data
public class Park {
    private String namePark;
    private Attraction attraction;
    private ArrayList<Attraction> attractions;

    public Park(String namePark) {
        this.namePark = namePark;
        attractions = new ArrayList<>();
    }

    public Park(String namePark, String nameAttraction, String workingHours, int price) {
        this.namePark = namePark;
        attraction = new Attraction(nameAttraction, workingHours, price);
        attractions = new ArrayList<>();
        attractions.add(attraction);
    }

    public void setAttractions(Attraction attraction) {
        attractions.add(attraction);
    }

    @Data
    public class Attraction {
        private String nameAttraction;
        private String workingHours;
        private int price;

        public Attraction(String nameAttraction, String workingHours, int price) {
            this.nameAttraction = nameAttraction;
            this.workingHours = workingHours;
            this.price = price;
        }

        public void showAttractionInfo() {
            System.out.println("Парк: " + namePark +
                    "\nАтракцион: " + this.nameAttraction +
                    "\nВремя работы: " + this.workingHours +
                    "\nСтоимость: " + this.price);
        }
    }
}

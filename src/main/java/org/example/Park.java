package org.example;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Park {
    private Attraction attraction;

    public Park(String nameAttraction, String workingHours, int price) {
        attraction = new Attraction(nameAttraction, workingHours, price);
    }

    @Setter
    @Getter
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
            System.out.println("Атракцион: " + this.nameAttraction +
                    "\nВремя работы: " + this.workingHours +
                    "\nСтоимость: " + this.price);
        }
    }
}

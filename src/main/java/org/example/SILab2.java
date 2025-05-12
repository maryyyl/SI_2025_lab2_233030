package org.example;

import java.util.List;

public class SILab2 {
    public  double checkCart(List<Item> allItems, String cardNumber){
        if (allItems == null){
            throw new RuntimeException("allItems list can't be null!");
            /*
            exit 1, test case 1
             */
        }

        double sum = 0;

        for (int i = 0; i < allItems.size(); i++){
            Item item = allItems.get(i);
            if (item.getName() == null || item.getName().length() == 0){
                throw new RuntimeException("Invalid item!");
                /*
                exit 2 , test case 2
                 */
            }

            if (item.getPrice() > 300 || item.getDiscount() > 0 || item.getQuantity() > 10){
                sum -= 30; //-30
            }

            if (item.getDiscount() > 0){
                sum += item.getPrice()*(1-item.getDiscount())*item.getQuantity(); //-30+=301*(1-1*0) =-30
            }
            else {
                sum += item.getPrice()*item.getQuantity();
            }

        }
        if (cardNumber != null && cardNumber.length() == 16) {
            String allowed = "0123456789";
            char[] chars = cardNumber.toCharArray();
            for (int j = 0; j < cardNumber.length(); j++) {//0-16
                char c = cardNumber.charAt(j);
                if (allowed.indexOf(c) == -1) {
                    throw new RuntimeException("Invalid character in card number!");
                    /*
                    exit 5, test case 5
                     */
                }
            }
        }
        else{
            throw new RuntimeException("Invalid card number!");
            /*
            exit 4 , test case 4
             */
        }

        return sum;
        /*
        exit 3 , test case 3
         */

    }
    public static class Item {
        String name;
        int quantity; //numerical
        int price;
        double discount;

        public Item(String name, int quantity, int price, double discount) {
            this.name = name;
            this.quantity = quantity;
            this.price = price;
            this.discount = discount;
        }

        public String getName() {
            return name;
        }

        public int getQuantity() {
            return quantity;
        }

        public int getPrice() {
            return price;
        }

        public double getDiscount() {
            return discount;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public void setDiscount(double discount) {
            this.discount = discount;
        }
    }
}

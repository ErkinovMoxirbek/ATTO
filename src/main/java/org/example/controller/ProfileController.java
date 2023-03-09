package org.example.controller;



import org.example.dto.Profile;
import org.example.service.CardService;
import org.example.util.ScannerUtil;

import java.util.Scanner;

public class ProfileController {
    private CardService cardService ;
    private Profile profile;

    public void start() {
        boolean b = true;

        while (b) {
            menu();
            int operation = ScannerUtil.getAction();
            switch (operation) {
                case 1:
                    addCard();
                    break;
                case 2:
                    cardList();
                    break;
                case 3:
                    changeCardStatus();
                    break;
                case 4:
                    deleteCard();
                    break;
                case 5:
                    refill();
                    break;
                case 6:
                    transactionList();
                    break;
                case 7:
                    payment();
                    break;
                case 0:
                    b = false;
                    break;
                default:
                    b = false;
                    System.out.println("Wrong operation number");
            }
        }
    }


    public void menu() {
        System.out.println("1. Add Card");
        System.out.println("2. Card List ");
        System.out.println("3. Card Change Status");
        System.out.println("4. Delete Card");
        System.out.println("5. ReFill ");
        System.out.println("6. Transaction List");
        System.out.println("7. Make Payment");
        System.out.println("0. Log out");
    }

    /**
     * Card
     */

    private void addCard() {
        System.out.print("Enter card number: ");

        Scanner scanner = new Scanner(System.in);
        String cardNumber = scanner.nextLine();
        cardService.addCardToProfile(profile.getPhone(), cardNumber);
    }

    private void cardList( ) {
        System.out.print("--- Card List ---");
        cardService.profileCardList(profile.getPhone());
    }

    private void changeCardStatus( ) {
        System.out.print("Enter card number: ");

        Scanner scanner = new Scanner(System.in);
        String cardNumber = scanner.nextLine();
        cardService.userChangeCardStatus(profile.getPhone(), cardNumber);
    }

    private void deleteCard( ) {
        System.out.print("Enter card number: ");
        Scanner scanner = new Scanner(System.in);
        String cardNumber = scanner.nextLine();
        cardService.userDeleteCard(profile.getPhone(), cardNumber);
    }

    private void refill( ) {
        System.out.print("Enter card number: ");
        Scanner scanner = new Scanner(System.in);
        String cardNumber = scanner.nextLine();

        System.out.print("Enter amount: ");
        Double amount = scanner.nextDouble();
        cardService.userRefillCard(profile.getPhone(), cardNumber, amount);
    }


    /**
     * Transaction
     */
    private void transactionList() {

    }

    private void payment() {

    }

    public void setCardService(CardService cardService) {
        this.cardService = cardService;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }
}

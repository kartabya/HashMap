package com.HashMap.dtoImpl;

import com.HashMap.dto.AddPlayers;

import java.util.HashMap;
import java.util.Scanner;

public class AddPlayersImpl implements AddPlayers {

    Scanner scanner=new Scanner(System.in);
    public void addPlayersToMap(HashMap<Integer,String> footballPlayers) {

            System.out.println("Enter players and their Jersey numbers: ");

            char ch;
            do {
                System.out.println("\nEnter Player name: ");
                String name= scanner.next();
                System.out.println("\nEnter " + name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase() + "'s jersey number: ");
                Integer jersey=scanner.nextInt();
                System.out.println("\nContinue adding players? (Y/N)");
                ch=scanner.next().charAt(0);
                footballPlayers.put(jersey,name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase());
            }while(ch=='Y' || ch=='y');
    }

    public void searchPlayersFromMap(HashMap<Integer,String> footballPlayers){

        System.out.println("\nWhat do you want to search through?\n1. Jersey Number\n2. Name\n3. Show all");
        int ch=scanner.nextInt();

        int flag=0;
        switch (ch){

            case 1:
                System.out.println("\nEnter the jersey number: ");
                int jersey= scanner.nextInt();
                for(HashMap.Entry<Integer,String> player: footballPlayers.entrySet()){
                    int key = player.getKey();
                    String value = player.getValue();
                    if(key==jersey){
                        System.out.println("\nMATCH FOUND");
                        System.out.println(key + " ; " + value);
                        flag=1;
                        break;
                    }
                }
                if(flag==0)
                {
                    System.out.println("\nNo entries matched!");
                }
                break;

            case 2:
                flag=0;
                System.out.println("\nEnter player name: ");
                String name= scanner.next();
                for(HashMap.Entry<Integer,String> player: footballPlayers.entrySet()){
                    Integer key = player.getKey();
                    String value = player.getValue();
                    if(value.equalsIgnoreCase(name)){
                        System.out.println(key + " ; " + value);
                        flag=1;
                        break;
                    }
                }
                if(flag==0)
                {
                    System.out.println("\nNo entries matched!");
                }
                break;

            case 3:
                for(HashMap.Entry<Integer,String> player: footballPlayers.entrySet()){
                Integer key = player.getKey();
                String value = player.getValue();
                System.out.println(key + " : " + value);
            }
                break;
            default:
                System.out.println("\nINVALID INPUT!");
                break;
        }
    }

    public void deletePlayersFromMap(HashMap<Integer,String> footballPlayers){

        System.out.println("Do you want to delete by name or jersey number? \n1. Name\n2. Jersey Number");
        int ch=scanner.nextInt();
        int jersey=0;
        String name=null;
        switch(ch)
        {
            case 2:
                System.out.println("\nEnter the jersey number of player you want to delete: ");
                jersey= scanner.nextInt();
                break;
            case 1:
                System.out.println("\nEnter the name of player you want to delete: ");
                name=scanner.next();
                break;
            default:
                System.out.println("\nINVALID INPUT!");
                break;
        }
        int flag=0;

        for(HashMap.Entry<Integer,String> player: footballPlayers.entrySet()){

            int key = player.getKey();
            String value = player.getValue();

            if((key == jersey) || value.equalsIgnoreCase(name)) {
                System.out.println("\nMATCH FOUND! " + value + " with jersey no. " + key + " has been deleted");
                footballPlayers.remove(key);
                flag=1;
                break;
            }
        }

        if(flag==0){
            System.out.println("No such record found");
        }
    }
}

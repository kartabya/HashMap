package com.HashMap;

import com.HashMap.dtoImpl.AddPlayersImpl;

import java.util.HashMap;
import java.util.Scanner;

public class HashMapMain {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        HashMap<Integer, String> footballPlayers = new HashMap<Integer, String>();
        AddPlayersImpl addplayers=new AddPlayersImpl();
        char loop;

        do{

        System.out.println("\nDo you want to add, search or delete players? \n1. Add \n2. Search\n3. Delete");
        int ch=scanner.nextInt();
        boolean emptyCheck=footballPlayers.isEmpty();
        switch (ch){

            case 1:
                addplayers.addPlayersToMap(footballPlayers);
                break;
            case 2:
                if(emptyCheck)
                {
                    System.out.println("No entries yet!");
                }
                else{
                    addplayers.searchPlayersFromMap(footballPlayers);
                }
                break;
            case 3:
                if(emptyCheck)
                {
                    System.out.println("No entries yet!");
                }
                else{
                    addplayers.deletePlayersFromMap(footballPlayers);
                }
                break;
            default:
                System.out.println("INVALID OPTION");
                break;
        }

        System.out.println("\nDo you want to continue with other operations? (Y/N)");
        loop=scanner.next().charAt(0);

    }while(loop=='y' || loop=='Y');
    }

}


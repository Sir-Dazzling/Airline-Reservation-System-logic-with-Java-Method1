package com.company;

import java.util.Scanner;

public class Main
{
    //Instantiating my array of airSeats and Scanner class.
    static boolean[] airSeats = new boolean[11];
    static Scanner input = new Scanner(System.in);

    public static void main(String args[])
    {
        while ( true )
        {
            bookSeat();
        }
    }

    // Method for booking a seat in air reservation system
    public static void bookSeat()
    {
        //Asking user for his preferred class to travel.
        System.out.println("Type 1 for FIrst class and 2 for Economy");
        int customerClass = input.nextInt();

        if ( customerClass == 1 )
        {
            firstClassBooking();
        }
        else
        {
            economyClassBooking();
        }
    }

    //Method to Check and book for first class seating
    public static void firstClassBooking()
    {
        for ( int i = 1; i <= 5; i++ )
        {
            //checking if seat is available to allocate to user booking.
            if ( airSeats[i] == false )
            {
                //booking the seat
                airSeats[i] = true;
                System.out.printf("Class: First Class \t\t Seat Booking: Seat# %d\n", i);
                break;
            }
            else if ( airSeats[5] == true )
            {
                if ( airSeats[10] == true)
                {
                        //if both classes are fully booked
                    System.out.println("Sorry, All seats are booked. Next flight is scheduled in '3' hours.");
                }
                else
                {
                    // providing customer with another available class option
                    System.out.println("Sorry,First Class bookings are over. Would you like to opt for Economy class ? select '1' for Yes and '2' for No");
                    int selection = input.nextInt();
                    if ( selection == 1 )
                    {
                        economyClassBooking();
                        bookSeat();
                    }
                    else
                    {
                        System.out.println("Next flight is scheduled in '3' hours.");
                        System.exit(0);
                    }
                }
            }
        }
    }

    // Check and book for economy class seating
    public static void economyClassBooking() // assign an economy seat
    {
        for ( int i = 6; i <= 10; i++ )
        {
            if ( airSeats[i] == false )
            {
                airSeats[i] = true;
                System.out.printf("Class: Economy \t\t Seat Booking: Seat# %d\n", i);
                break;
            }
            else if ( airSeats[10] == true )
            {
                if ( airSeats[5] == true)
                {
                    System.out.println("Sorry, All seats are booked. Next flight is scheduled in '3' hours.");
                    System.exit(0);
                }
                else
                {
                    System.out.println("Sorry, Economy Class seat bookings are over. Would you like to opt for first Class seat? press '1' for Yes and '2' for No");
                    int selection = input.nextInt();
                    if ( selection == 1 )
                    {
                        firstClassBooking();
                        bookSeat();
                    }
                    else
                    {
                        System.out.println("Next flight is scheduled in 3 hours");
                        System.exit(0);
                    }
                }
            }
        }
    }
}

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Seat
{
    private int ID;         // Identifiant du siège
    private int x;          // Coordonnée x du siège
    private int y;          // Coordonnée y du siège
    private boolean free;   // Siège libre ou non

    public Seat(boolean free)
    {
        this.free = free;
    }

    /**
     * Lecture d'un fichier .txt "seat" pour ajouter
     * les sièges dans une liste de sièges
     * @param listSeats liste des sièges
     */
    public void loadSeat(ArrayList<Seat> listSeats)
    {
        try
        {
            // Chemin du fichier texte, à changer par rapport à vous !!
            File myObj = new File("C:\\Users\\Guill\\Documents\\GitHub\\MaximumSeatAllocationProblem\\seat.txt");
            Scanner myReader = new Scanner(myObj);
            // Permet de skipper la 1ère ligne qui contient les en-têtes
            String data = myReader.nextLine();
            while (myReader.hasNextLine() )
            {
                Seat seat = new Seat(true);
                data = myReader.nextLine();
                String[] temp = data.split("\\s+");
                seat.setID(Integer.parseInt(temp[0]));
                seat.setX(Integer.parseInt(temp[1]));
                seat.setY(Integer.parseInt(temp[2]));
                listSeats.add(seat);
            }
            myReader.close();
        }
        catch (FileNotFoundException e)
        {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    /**
     * GETTERS
     */

    public int getID() {
        return ID;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isFree() {
        return free;
    }

    /**
     * SETTERS
     */

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setFree(boolean free) {
        this.free = free;
    }


}

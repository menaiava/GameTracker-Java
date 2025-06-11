/**
 * This class represents a Game.
 * Each game has a unique ID, title, genre, 
 * and a status which tells us the actual gaming status.
 *
 * @author Filomena Iavarone
 * @version 27-04-2025
 */
public class Game implements Comparable<Game>
{
    
    private int gameID;
    private String title;
    private String genre;
    private String status;

    //Constants for game status
    public static final String IN_PROGRESS = "In progress";
    public static final String NOT_STARTED = "Not started";
    public static final String COMPLETED = "Completed";

    /** 
     * Q.2(c)(i)
     * Initialise a game with a title, genre and status.
     * The status is checked and matched to a valid costant.
     * 
     * @param anID the ID of the game
     * @param aTitle The title of the game
     * @param aGenre The genre of the game
     * @param sStatus The status of the game. It can only be set to Not started, In progress, or Completed.
     * @thows IllegalArgumentException if the status is not valid.
     */
    public Game(int anID, String aTitle, String aGenre, String aStatus)
    {
        gameID = anID;
        title = aTitle;
        genre = aGenre;
        setStatus(aStatus);
    }

    /**
     * Gets the game ID
     * 
     * @return The game unique ID.
     */
    public int getGameID()
    {
        return gameID;
    }

    /**
     * Gets the title of the game
     * 
     * @return The title of the game
     */
    public String getTitle()
    {
        return title;
    }

    /**
     * Gets the genre of the game
     * 
     * @return The genre of the game
     */
    public String getGenre()
    {
        return genre;
    }

    /**
     * Gets the status of the game
     * 
     * @return the status of the game
     */
    public String getStatus()
    {
        return status;
    }

    /**
     * Set the status by checking and matching the inputted status to the constant.
     * If the status inputted is not valid, it will throw an exception.
     * 
     * @param aStatus The new status of the game.
     * @throws IllegalArgumentException if status is not valid.
     */
    public void setStatus(String aStatus)
    { 
        String inputStatus = aStatus.trim();
        if(inputStatus.equalsIgnoreCase("not started")){
            status = NOT_STARTED;
        }
        else if(inputStatus.equalsIgnoreCase("in progress")){
            status = IN_PROGRESS;
        }
        else if(inputStatus.equalsIgnoreCase("completed")){
            status = COMPLETED;
        }
        else{
            throw new IllegalArgumentException(
                "Invalid status: \""
                + aStatus 
                + "\""
                + "Valid options are: Not started,In progress, Completed.");
        }
    }

    /**
     * It return a string with the game details.
     * Game ID, title, genre and status.
     * 
     * @return String with the details of the game
     */
    @Override
    public String toString()
    {
        return "ID: " + gameID 
        + ", Title: " + title 
        + ", Genre: " + genre 
        + ", Status: " + status;
    }

    /**
     * It check if two games are equals
     * by checking their gameID
     * 
     * @param obj The object we use to compare.
     * @return true if the gameId are the same, false otherwise.
     */
    @Override
    public boolean equals(Object obj)
    {
        if (obj == null){
            return false;
        }
        if(this.getClass() != obj.getClass()){
            return false;
        }
        Game otherGame = (Game) obj;
        if(this.title.equalsIgnoreCase((otherGame.title))){
            return true;
        }
        else{
            return false;
        }

    }

    /**
     * Return a hash code for this Game using the gameID.
     * 
     * @return an integer hash code based on the gameID.
     */
    @Override
    public int hashCode()
    {
        return this.title.toLowerCase().hashCode();
    }

    /**
     * Compare this Game to another Game using titles.
     * This also allows us to sort games by their titles.
     * 
     * @param   otherGame is the other game to be compared to.
     * @return  a negative number if this title comes first, 
     *          a positive number if this title comes after, 
     *          0 if the titles are the same (case-insensitive).
     */
    @Override
    public int compareTo(Game otherGame)
    {
        return this.title.compareToIgnoreCase(otherGame.title);
    }
}

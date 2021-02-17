package sql;

public class IndividualAuthor {
    private int authorID;
    private String firstName;
    private String lastName;
    

    public IndividualAuthor( int id, String first, String last )
    {
        setAuthorID(id);
        setFirstName(first);
        setLastName(last);
    }
    
    public void setAuthorID( int id)
    {
        authorID = id;
    }
    public int getAuthorID()
    {
        return authorID;
    }
    
    public void setFirstName( String first)
    {
        firstName = first;
    }
    public String getFirstName()
    {
        return firstName;
    }
    
    public void setLastName( String last)
    {
        lastName = last;
    }
    public String getLastName()
    {
        return lastName;
    }

}

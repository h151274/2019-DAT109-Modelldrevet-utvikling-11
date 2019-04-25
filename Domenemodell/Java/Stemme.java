/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.1.4448.81a70243a modeling language!*/


import java.sql.Date;
import java.util.*;

// line 18 "model.ump"
// line 85 "model.ump"
public class Stemme
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Stemme Attributes
  private String epost;
  private int verdi;
  private Date tidspunkt;

  //Stemme Associations
  private List<Arrangementdeltagelse> arrangementdeltagelses;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Stemme(String aEpost, int aVerdi, Date aTidspunkt)
  {
    epost = aEpost;
    verdi = aVerdi;
    tidspunkt = aTidspunkt;
    arrangementdeltagelses = new ArrayList<Arrangementdeltagelse>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setEpost(String aEpost)
  {
    boolean wasSet = false;
    epost = aEpost;
    wasSet = true;
    return wasSet;
  }

  public boolean setVerdi(int aVerdi)
  {
    boolean wasSet = false;
    verdi = aVerdi;
    wasSet = true;
    return wasSet;
  }

  public boolean setTidspunkt(Date aTidspunkt)
  {
    boolean wasSet = false;
    tidspunkt = aTidspunkt;
    wasSet = true;
    return wasSet;
  }

  public String getEpost()
  {
    return epost;
  }

  public int getVerdi()
  {
    return verdi;
  }

  public Date getTidspunkt()
  {
    return tidspunkt;
  }
  /* Code from template association_GetMany */
  public Arrangementdeltagelse getArrangementdeltagelse(int index)
  {
    Arrangementdeltagelse aArrangementdeltagelse = arrangementdeltagelses.get(index);
    return aArrangementdeltagelse;
  }

  public List<Arrangementdeltagelse> getArrangementdeltagelses()
  {
    List<Arrangementdeltagelse> newArrangementdeltagelses = Collections.unmodifiableList(arrangementdeltagelses);
    return newArrangementdeltagelses;
  }

  public int numberOfArrangementdeltagelses()
  {
    int number = arrangementdeltagelses.size();
    return number;
  }

  public boolean hasArrangementdeltagelses()
  {
    boolean has = arrangementdeltagelses.size() > 0;
    return has;
  }

  public int indexOfArrangementdeltagelse(Arrangementdeltagelse aArrangementdeltagelse)
  {
    int index = arrangementdeltagelses.indexOf(aArrangementdeltagelse);
    return index;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfArrangementdeltagelses()
  {
    return 0;
  }
  /* Code from template association_AddManyToManyMethod */
  public boolean addArrangementdeltagelse(Arrangementdeltagelse aArrangementdeltagelse)
  {
    boolean wasAdded = false;
    if (arrangementdeltagelses.contains(aArrangementdeltagelse)) { return false; }
    arrangementdeltagelses.add(aArrangementdeltagelse);
    if (aArrangementdeltagelse.indexOfStemme(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aArrangementdeltagelse.addStemme(this);
      if (!wasAdded)
      {
        arrangementdeltagelses.remove(aArrangementdeltagelse);
      }
    }
    return wasAdded;
  }
  /* Code from template association_RemoveMany */
  public boolean removeArrangementdeltagelse(Arrangementdeltagelse aArrangementdeltagelse)
  {
    boolean wasRemoved = false;
    if (!arrangementdeltagelses.contains(aArrangementdeltagelse))
    {
      return wasRemoved;
    }

    int oldIndex = arrangementdeltagelses.indexOf(aArrangementdeltagelse);
    arrangementdeltagelses.remove(oldIndex);
    if (aArrangementdeltagelse.indexOfStemme(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aArrangementdeltagelse.removeStemme(this);
      if (!wasRemoved)
      {
        arrangementdeltagelses.add(oldIndex,aArrangementdeltagelse);
      }
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addArrangementdeltagelseAt(Arrangementdeltagelse aArrangementdeltagelse, int index)
  {  
    boolean wasAdded = false;
    if(addArrangementdeltagelse(aArrangementdeltagelse))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfArrangementdeltagelses()) { index = numberOfArrangementdeltagelses() - 1; }
      arrangementdeltagelses.remove(aArrangementdeltagelse);
      arrangementdeltagelses.add(index, aArrangementdeltagelse);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveArrangementdeltagelseAt(Arrangementdeltagelse aArrangementdeltagelse, int index)
  {
    boolean wasAdded = false;
    if(arrangementdeltagelses.contains(aArrangementdeltagelse))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfArrangementdeltagelses()) { index = numberOfArrangementdeltagelses() - 1; }
      arrangementdeltagelses.remove(aArrangementdeltagelse);
      arrangementdeltagelses.add(index, aArrangementdeltagelse);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addArrangementdeltagelseAt(aArrangementdeltagelse, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    ArrayList<Arrangementdeltagelse> copyOfArrangementdeltagelses = new ArrayList<Arrangementdeltagelse>(arrangementdeltagelses);
    arrangementdeltagelses.clear();
    for(Arrangementdeltagelse aArrangementdeltagelse : copyOfArrangementdeltagelses)
    {
      aArrangementdeltagelse.removeStemme(this);
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "epost" + ":" + getEpost()+ "," +
            "verdi" + ":" + getVerdi()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "tidspunkt" + "=" + (getTidspunkt() != null ? !getTidspunkt().equals(this)  ? getTidspunkt().toString().replaceAll("  ","    ") : "this" : "null");
  }
}
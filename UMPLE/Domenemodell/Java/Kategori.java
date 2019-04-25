/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.1.4448.81a70243a modeling language!*/


import java.util.*;

// line 62 "model.ump"
// line 124 "model.ump"
public class Kategori
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Kategori Attributes
  private String navn;
  private String beskrivelse;

  //Kategori Associations
  private List<Studie> studies;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Kategori(String aNavn, String aBeskrivelse)
  {
    navn = aNavn;
    beskrivelse = aBeskrivelse;
    studies = new ArrayList<Studie>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setNavn(String aNavn)
  {
    boolean wasSet = false;
    navn = aNavn;
    wasSet = true;
    return wasSet;
  }

  public boolean setBeskrivelse(String aBeskrivelse)
  {
    boolean wasSet = false;
    beskrivelse = aBeskrivelse;
    wasSet = true;
    return wasSet;
  }

  public String getNavn()
  {
    return navn;
  }

  public String getBeskrivelse()
  {
    return beskrivelse;
  }
  /* Code from template association_GetMany */
  public Studie getStudy(int index)
  {
    Studie aStudy = studies.get(index);
    return aStudy;
  }

  public List<Studie> getStudies()
  {
    List<Studie> newStudies = Collections.unmodifiableList(studies);
    return newStudies;
  }

  public int numberOfStudies()
  {
    int number = studies.size();
    return number;
  }

  public boolean hasStudies()
  {
    boolean has = studies.size() > 0;
    return has;
  }

  public int indexOfStudy(Studie aStudy)
  {
    int index = studies.indexOf(aStudy);
    return index;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfStudies()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Studie addStudy(String aNavn, String aBeskrivelse)
  {
    return new Studie(aNavn, aBeskrivelse, this);
  }

  public boolean addStudy(Studie aStudy)
  {
    boolean wasAdded = false;
    if (studies.contains(aStudy)) { return false; }
    Kategori existingKategori = aStudy.getKategori();
    boolean isNewKategori = existingKategori != null && !this.equals(existingKategori);
    if (isNewKategori)
    {
      aStudy.setKategori(this);
    }
    else
    {
      studies.add(aStudy);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeStudy(Studie aStudy)
  {
    boolean wasRemoved = false;
    //Unable to remove aStudy, as it must always have a kategori
    if (!this.equals(aStudy.getKategori()))
    {
      studies.remove(aStudy);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addStudyAt(Studie aStudy, int index)
  {  
    boolean wasAdded = false;
    if(addStudy(aStudy))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfStudies()) { index = numberOfStudies() - 1; }
      studies.remove(aStudy);
      studies.add(index, aStudy);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveStudyAt(Studie aStudy, int index)
  {
    boolean wasAdded = false;
    if(studies.contains(aStudy))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfStudies()) { index = numberOfStudies() - 1; }
      studies.remove(aStudy);
      studies.add(index, aStudy);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addStudyAt(aStudy, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    for(int i=studies.size(); i > 0; i--)
    {
      Studie aStudy = studies.get(i - 1);
      aStudy.delete();
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "navn" + ":" + getNavn()+ "," +
            "beskrivelse" + ":" + getBeskrivelse()+ "]";
  }
}
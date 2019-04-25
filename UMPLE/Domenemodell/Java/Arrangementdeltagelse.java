/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.1.4448.81a70243a modeling language!*/


import java.util.*;

// line 10 "model.ump"
// line 77 "model.ump"
public class Arrangementdeltagelse
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Arrangementdeltagelse Associations
  private Prosjekt prosjekt;
  private Arrengement arrengement;
  private List<Stemme> stemmes;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Arrangementdeltagelse(Prosjekt aProsjekt, Arrengement aArrengement)
  {
    boolean didAddProsjekt = setProsjekt(aProsjekt);
    if (!didAddProsjekt)
    {
      throw new RuntimeException("Unable to create arrangementdeltagelse due to prosjekt");
    }
    boolean didAddArrengement = setArrengement(aArrengement);
    if (!didAddArrengement)
    {
      throw new RuntimeException("Unable to create arrangementdeltagelse due to arrengement");
    }
    stemmes = new ArrayList<Stemme>();
  }

  //------------------------
  // INTERFACE
  //------------------------
  /* Code from template association_GetOne */
  public Prosjekt getProsjekt()
  {
    return prosjekt;
  }
  /* Code from template association_GetOne */
  public Arrengement getArrengement()
  {
    return arrengement;
  }
  /* Code from template association_GetMany */
  public Stemme getStemme(int index)
  {
    Stemme aStemme = stemmes.get(index);
    return aStemme;
  }

  public List<Stemme> getStemmes()
  {
    List<Stemme> newStemmes = Collections.unmodifiableList(stemmes);
    return newStemmes;
  }

  public int numberOfStemmes()
  {
    int number = stemmes.size();
    return number;
  }

  public boolean hasStemmes()
  {
    boolean has = stemmes.size() > 0;
    return has;
  }

  public int indexOfStemme(Stemme aStemme)
  {
    int index = stemmes.indexOf(aStemme);
    return index;
  }
  /* Code from template association_SetOneToMany */
  public boolean setProsjekt(Prosjekt aProsjekt)
  {
    boolean wasSet = false;
    if (aProsjekt == null)
    {
      return wasSet;
    }

    Prosjekt existingProsjekt = prosjekt;
    prosjekt = aProsjekt;
    if (existingProsjekt != null && !existingProsjekt.equals(aProsjekt))
    {
      existingProsjekt.removeArrangementdeltagelse(this);
    }
    prosjekt.addArrangementdeltagelse(this);
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_SetOneToMany */
  public boolean setArrengement(Arrengement aArrengement)
  {
    boolean wasSet = false;
    if (aArrengement == null)
    {
      return wasSet;
    }

    Arrengement existingArrengement = arrengement;
    arrengement = aArrengement;
    if (existingArrengement != null && !existingArrengement.equals(aArrengement))
    {
      existingArrengement.removeArrangementdeltagelse(this);
    }
    arrengement.addArrangementdeltagelse(this);
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfStemmes()
  {
    return 0;
  }
  /* Code from template association_AddManyToManyMethod */
  public boolean addStemme(Stemme aStemme)
  {
    boolean wasAdded = false;
    if (stemmes.contains(aStemme)) { return false; }
    stemmes.add(aStemme);
    if (aStemme.indexOfArrangementdeltagelse(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aStemme.addArrangementdeltagelse(this);
      if (!wasAdded)
      {
        stemmes.remove(aStemme);
      }
    }
    return wasAdded;
  }
  /* Code from template association_RemoveMany */
  public boolean removeStemme(Stemme aStemme)
  {
    boolean wasRemoved = false;
    if (!stemmes.contains(aStemme))
    {
      return wasRemoved;
    }

    int oldIndex = stemmes.indexOf(aStemme);
    stemmes.remove(oldIndex);
    if (aStemme.indexOfArrangementdeltagelse(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aStemme.removeArrangementdeltagelse(this);
      if (!wasRemoved)
      {
        stemmes.add(oldIndex,aStemme);
      }
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addStemmeAt(Stemme aStemme, int index)
  {  
    boolean wasAdded = false;
    if(addStemme(aStemme))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfStemmes()) { index = numberOfStemmes() - 1; }
      stemmes.remove(aStemme);
      stemmes.add(index, aStemme);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveStemmeAt(Stemme aStemme, int index)
  {
    boolean wasAdded = false;
    if(stemmes.contains(aStemme))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfStemmes()) { index = numberOfStemmes() - 1; }
      stemmes.remove(aStemme);
      stemmes.add(index, aStemme);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addStemmeAt(aStemme, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    Prosjekt placeholderProsjekt = prosjekt;
    this.prosjekt = null;
    if(placeholderProsjekt != null)
    {
      placeholderProsjekt.removeArrangementdeltagelse(this);
    }
    Arrengement placeholderArrengement = arrengement;
    this.arrengement = null;
    if(placeholderArrengement != null)
    {
      placeholderArrengement.removeArrangementdeltagelse(this);
    }
    ArrayList<Stemme> copyOfStemmes = new ArrayList<Stemme>(stemmes);
    stemmes.clear();
    for(Stemme aStemme : copyOfStemmes)
    {
      aStemme.removeArrangementdeltagelse(this);
    }
  }

}
<?php
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.1.4448.81a70243a modeling language!*/

class Bruker
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Bruker Attributes
  private $brukernavn;

  //Bruker Associations
  private $prosjekts;
  private $brukegruppe;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public function __construct($aBrukernavn, $aBrukegruppe)
  {
    $this->brukernavn = $aBrukernavn;
    $this->prosjekts = array();
    $didAddBrukegruppe = $this->setBrukegruppe($aBrukegruppe);
    if (!$didAddBrukegruppe)
    {
      throw new Exception("Unable to create bruker due to brukegruppe");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public function setBrukernavn($aBrukernavn)
  {
    $wasSet = false;
    $this->brukernavn = $aBrukernavn;
    $wasSet = true;
    return $wasSet;
  }

  public function getBrukernavn()
  {
    return $this->brukernavn;
  }

  public function getProsjekt_index($index)
  {
    $aProsjekt = $this->prosjekts[$index];
    return $aProsjekt;
  }

  public function getProsjekts()
  {
    $newProsjekts = $this->prosjekts;
    return $newProsjekts;
  }

  public function numberOfProsjekts()
  {
    $number = count($this->prosjekts);
    return $number;
  }

  public function hasProsjekts()
  {
    $has = $this->numberOfProsjekts() > 0;
    return $has;
  }

  public function indexOfProsjekt($aProsjekt)
  {
    $wasFound = false;
    $index = 0;
    foreach($this->prosjekts as $prosjekt)
    {
      if ($prosjekt->equals($aProsjekt))
      {
        $wasFound = true;
        break;
      }
      $index += 1;
    }
    $index = $wasFound ? $index : -1;
    return $index;
  }

  public function getBrukegruppe()
  {
    return $this->brukegruppe;
  }

  public static function minimumNumberOfProsjekts()
  {
    return 0;
  }

  public function addProsjektVia($aNavn, $aBeskrivelse, $aStudie, $aBedrift)
  {
    return new Prosjekt($aNavn, $aBeskrivelse, $aStudie, $this, $aBedrift);
  }

  public function addProsjekt($aProsjekt)
  {
    $wasAdded = false;
    if ($this->indexOfProsjekt($aProsjekt) !== -1) { return false; }
    $existingBruker = $aProsjekt->getBruker();
    $isNewBruker = $existingBruker != null && $this !== $existingBruker;
    if ($isNewBruker)
    {
      $aProsjekt->setBruker($this);
    }
    else
    {
      $this->prosjekts[] = $aProsjekt;
    }
    $wasAdded = true;
    return $wasAdded;
  }

  public function removeProsjekt($aProsjekt)
  {
    $wasRemoved = false;
    //Unable to remove aProsjekt, as it must always have a bruker
    if ($this !== $aProsjekt->getBruker())
    {
      unset($this->prosjekts[$this->indexOfProsjekt($aProsjekt)]);
      $this->prosjekts = array_values($this->prosjekts);
      $wasRemoved = true;
    }
    return $wasRemoved;
  }

  public function addProsjektAt($aProsjekt, $index)
  {  
    $wasAdded = false;
    if($this->addProsjekt($aProsjekt))
    {
      if($index < 0 ) { $index = 0; }
      if($index > $this->numberOfProsjekts()) { $index = $this->numberOfProsjekts() - 1; }
      array_splice($this->prosjekts, $this->indexOfProsjekt($aProsjekt), 1);
      array_splice($this->prosjekts, $index, 0, array($aProsjekt));
      $wasAdded = true;
    }
    return $wasAdded;
  }

  public function addOrMoveProsjektAt($aProsjekt, $index)
  {
    $wasAdded = false;
    if($this->indexOfProsjekt($aProsjekt) !== -1)
    {
      if($index < 0 ) { $index = 0; }
      if($index > $this->numberOfProsjekts()) { $index = $this->numberOfProsjekts() - 1; }
      array_splice($this->prosjekts, $this->indexOfProsjekt($aProsjekt), 1);
      array_splice($this->prosjekts, $index, 0, array($aProsjekt));
      $wasAdded = true;
    } 
    else 
    {
      $wasAdded = $this->addProsjektAt($aProsjekt, $index);
    }
    return $wasAdded;
  }

  public function setBrukegruppe($aBrukegruppe)
  {
    $wasSet = false;
    if ($aBrukegruppe == null)
    {
      return $wasSet;
    }
    
    $existingBrukegruppe = $this->brukegruppe;
    $this->brukegruppe = $aBrukegruppe;
    if ($existingBrukegruppe != null && $existingBrukegruppe != $aBrukegruppe)
    {
      $existingBrukegruppe->removeBruker($this);
    }
    $this->brukegruppe->addBruker($this);
    $wasSet = true;
    return $wasSet;
  }

  public function equals($compareTo)
  {
    return $this == $compareTo;
  }

  public function delete()
  {
    foreach ($this->prosjekts as $aProsjekt)
    {
      $aProsjekt->delete();
    }
    $placeholderBrukegruppe = $this->brukegruppe;
    $this->brukegruppe = null;
    $placeholderBrukegruppe->removeBruker($this);
  }

}
?>
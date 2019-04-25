<?php
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.1.4448.81a70243a modeling language!*/

class Stemmemetode
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Stemmemetode Associations
  private $arrengements;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public function __construct()
  {
    $this->arrengements = array();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public function getArrengement_index($index)
  {
    $aArrengement = $this->arrengements[$index];
    return $aArrengement;
  }

  public function getArrengements()
  {
    $newArrengements = $this->arrengements;
    return $newArrengements;
  }

  public function numberOfArrengements()
  {
    $number = count($this->arrengements);
    return $number;
  }

  public function hasArrengements()
  {
    $has = $this->numberOfArrengements() > 0;
    return $has;
  }

  public function indexOfArrengement($aArrengement)
  {
    $wasFound = false;
    $index = 0;
    foreach($this->arrengements as $arrengement)
    {
      if ($arrengement->equals($aArrengement))
      {
        $wasFound = true;
        break;
      }
      $index += 1;
    }
    $index = $wasFound ? $index : -1;
    return $index;
  }

  public static function minimumNumberOfArrengements()
  {
    return 0;
  }

  public function addArrengementVia($aNavn, $aBeskrivelse, $aUtgaar)
  {
    return new Arrengement($aNavn, $aBeskrivelse, $aUtgaar, $this);
  }

  public function addArrengement($aArrengement)
  {
    $wasAdded = false;
    if ($this->indexOfArrengement($aArrengement) !== -1) { return false; }
    $existingStemmemetode = $aArrengement->getStemmemetode();
    $isNewStemmemetode = $existingStemmemetode != null && $this !== $existingStemmemetode;
    if ($isNewStemmemetode)
    {
      $aArrengement->setStemmemetode($this);
    }
    else
    {
      $this->arrengements[] = $aArrengement;
    }
    $wasAdded = true;
    return $wasAdded;
  }

  public function removeArrengement($aArrengement)
  {
    $wasRemoved = false;
    //Unable to remove aArrengement, as it must always have a stemmemetode
    if ($this !== $aArrengement->getStemmemetode())
    {
      unset($this->arrengements[$this->indexOfArrengement($aArrengement)]);
      $this->arrengements = array_values($this->arrengements);
      $wasRemoved = true;
    }
    return $wasRemoved;
  }

  public function addArrengementAt($aArrengement, $index)
  {  
    $wasAdded = false;
    if($this->addArrengement($aArrengement))
    {
      if($index < 0 ) { $index = 0; }
      if($index > $this->numberOfArrengements()) { $index = $this->numberOfArrengements() - 1; }
      array_splice($this->arrengements, $this->indexOfArrengement($aArrengement), 1);
      array_splice($this->arrengements, $index, 0, array($aArrengement));
      $wasAdded = true;
    }
    return $wasAdded;
  }

  public function addOrMoveArrengementAt($aArrengement, $index)
  {
    $wasAdded = false;
    if($this->indexOfArrengement($aArrengement) !== -1)
    {
      if($index < 0 ) { $index = 0; }
      if($index > $this->numberOfArrengements()) { $index = $this->numberOfArrengements() - 1; }
      array_splice($this->arrengements, $this->indexOfArrengement($aArrengement), 1);
      array_splice($this->arrengements, $index, 0, array($aArrengement));
      $wasAdded = true;
    } 
    else 
    {
      $wasAdded = $this->addArrengementAt($aArrengement, $index);
    }
    return $wasAdded;
  }

  public function equals($compareTo)
  {
    return $this == $compareTo;
  }

  public function delete()
  {
    foreach ($this->arrengements as $aArrengement)
    {
      $aArrengement->delete();
    }
  }

}
?>
<?php
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.1.4448.81a70243a modeling language!*/

class Arrangementdeltagelse
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Arrangementdeltagelse Associations
  private $prosjekt;
  private $arrengement;
  private $stemmes;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public function __construct($aProsjekt, $aArrengement)
  {
    $didAddProsjekt = $this->setProsjekt($aProsjekt);
    if (!$didAddProsjekt)
    {
      throw new Exception("Unable to create arrangementdeltagelse due to prosjekt");
    }
    $didAddArrengement = $this->setArrengement($aArrengement);
    if (!$didAddArrengement)
    {
      throw new Exception("Unable to create arrangementdeltagelse due to arrengement");
    }
    $this->stemmes = array();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public function getProsjekt()
  {
    return $this->prosjekt;
  }

  public function getArrengement()
  {
    return $this->arrengement;
  }

  public function getStemme_index($index)
  {
    $aStemme = $this->stemmes[$index];
    return $aStemme;
  }

  public function getStemmes()
  {
    $newStemmes = $this->stemmes;
    return $newStemmes;
  }

  public function numberOfStemmes()
  {
    $number = count($this->stemmes);
    return $number;
  }

  public function hasStemmes()
  {
    $has = $this->numberOfStemmes() > 0;
    return $has;
  }

  public function indexOfStemme($aStemme)
  {
    $wasFound = false;
    $index = 0;
    foreach($this->stemmes as $stemme)
    {
      if ($stemme->equals($aStemme))
      {
        $wasFound = true;
        break;
      }
      $index += 1;
    }
    $index = $wasFound ? $index : -1;
    return $index;
  }

  public function setProsjekt($aProsjekt)
  {
    $wasSet = false;
    if ($aProsjekt == null)
    {
      return $wasSet;
    }
    
    $existingProsjekt = $this->prosjekt;
    $this->prosjekt = $aProsjekt;
    if ($existingProsjekt != null && $existingProsjekt != $aProsjekt)
    {
      $existingProsjekt->removeArrangementdeltagelse($this);
    }
    $this->prosjekt->addArrangementdeltagelse($this);
    $wasSet = true;
    return $wasSet;
  }

  public function setArrengement($aArrengement)
  {
    $wasSet = false;
    if ($aArrengement == null)
    {
      return $wasSet;
    }
    
    $existingArrengement = $this->arrengement;
    $this->arrengement = $aArrengement;
    if ($existingArrengement != null && $existingArrengement != $aArrengement)
    {
      $existingArrengement->removeArrangementdeltagelse($this);
    }
    $this->arrengement->addArrangementdeltagelse($this);
    $wasSet = true;
    return $wasSet;
  }

  public static function minimumNumberOfStemmes()
  {
    return 0;
  }

  public function addStemme($aStemme)
  {
    $wasAdded = false;
    if ($this->indexOfStemme($aStemme) !== -1) { return false; }
    $this->stemmes[] = $aStemme;
    if ($aStemme->indexOfArrangementdeltagelse($this) != -1)
    {
      $wasAdded = true;
    }
    else
    {
      $wasAdded = $aStemme->addArrangementdeltagelse($this);
      if (!$wasAdded)
      {
        array_pop($this->stemmes);
      }
    }
    return $wasAdded;
  }

  public function removeStemme($aStemme)
  {
    $wasRemoved = false;
    if ($this->indexOfStemme($aStemme) == -1)
    {
      return $wasRemoved;
    }

    $oldIndex = $this->indexOfStemme($aStemme);
    unset($this->stemmes[$oldIndex]);
    if ($aStemme->indexOfArrangementdeltagelse($this) == -1)
    {
      $wasRemoved = true;
    }
    else
    {
      $wasRemoved = $aStemme->removeArrangementdeltagelse($this);
      if (!$wasRemoved)
      {
        $this->stemmes[$oldIndex] = $aStemme;
        ksort($this->stemmes);
      }
    }
    $this->stemmes = array_values($this->stemmes);
    return $wasRemoved;
  }

  public function addStemmeAt($aStemme, $index)
  {  
    $wasAdded = false;
    if($this->addStemme($aStemme))
    {
      if($index < 0 ) { $index = 0; }
      if($index > $this->numberOfStemmes()) { $index = $this->numberOfStemmes() - 1; }
      array_splice($this->stemmes, $this->indexOfStemme($aStemme), 1);
      array_splice($this->stemmes, $index, 0, array($aStemme));
      $wasAdded = true;
    }
    return $wasAdded;
  }

  public function addOrMoveStemmeAt($aStemme, $index)
  {
    $wasAdded = false;
    if($this->indexOfStemme($aStemme) !== -1)
    {
      if($index < 0 ) { $index = 0; }
      if($index > $this->numberOfStemmes()) { $index = $this->numberOfStemmes() - 1; }
      array_splice($this->stemmes, $this->indexOfStemme($aStemme), 1);
      array_splice($this->stemmes, $index, 0, array($aStemme));
      $wasAdded = true;
    } 
    else 
    {
      $wasAdded = $this->addStemmeAt($aStemme, $index);
    }
    return $wasAdded;
  }

  public function equals($compareTo)
  {
    return $this == $compareTo;
  }

  public function delete()
  {
    $placeholderProsjekt = $this->prosjekt;
    $this->prosjekt = null;
    $placeholderProsjekt->removeArrangementdeltagelse($this);
    $placeholderArrengement = $this->arrengement;
    $this->arrengement = null;
    $placeholderArrengement->removeArrangementdeltagelse($this);
    $copyOfStemmes = $this->stemmes;
    $this->stemmes = array();
    foreach ($copyOfStemmes as $aStemme)
    {
      $aStemme->removeArrangementdeltagelse($this);
    }
  }

}
?>
<?php
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.29.1.4448.81a70243a modeling language!*/

class Stemme
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Stemme Attributes
  private $epost;
  private $verdi;
  private $tidspunkt;

  //Stemme Associations
  private $arrangementdeltagelses;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public function __construct($aEpost, $aVerdi, $aTidspunkt)
  {
    $this->epost = $aEpost;
    $this->verdi = $aVerdi;
    $this->tidspunkt = $aTidspunkt;
    $this->arrangementdeltagelses = array();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public function setEpost($aEpost)
  {
    $wasSet = false;
    $this->epost = $aEpost;
    $wasSet = true;
    return $wasSet;
  }

  public function setVerdi($aVerdi)
  {
    $wasSet = false;
    $this->verdi = $aVerdi;
    $wasSet = true;
    return $wasSet;
  }

  public function setTidspunkt($aTidspunkt)
  {
    $wasSet = false;
    $this->tidspunkt = $aTidspunkt;
    $wasSet = true;
    return $wasSet;
  }

  public function getEpost()
  {
    return $this->epost;
  }

  public function getVerdi()
  {
    return $this->verdi;
  }

  public function getTidspunkt()
  {
    return $this->tidspunkt;
  }

  public function getArrangementdeltagelse_index($index)
  {
    $aArrangementdeltagelse = $this->arrangementdeltagelses[$index];
    return $aArrangementdeltagelse;
  }

  public function getArrangementdeltagelses()
  {
    $newArrangementdeltagelses = $this->arrangementdeltagelses;
    return $newArrangementdeltagelses;
  }

  public function numberOfArrangementdeltagelses()
  {
    $number = count($this->arrangementdeltagelses);
    return $number;
  }

  public function hasArrangementdeltagelses()
  {
    $has = $this->numberOfArrangementdeltagelses() > 0;
    return $has;
  }

  public function indexOfArrangementdeltagelse($aArrangementdeltagelse)
  {
    $wasFound = false;
    $index = 0;
    foreach($this->arrangementdeltagelses as $arrangementdeltagelse)
    {
      if ($arrangementdeltagelse->equals($aArrangementdeltagelse))
      {
        $wasFound = true;
        break;
      }
      $index += 1;
    }
    $index = $wasFound ? $index : -1;
    return $index;
  }

  public static function minimumNumberOfArrangementdeltagelses()
  {
    return 0;
  }

  public function addArrangementdeltagelse($aArrangementdeltagelse)
  {
    $wasAdded = false;
    if ($this->indexOfArrangementdeltagelse($aArrangementdeltagelse) !== -1) { return false; }
    $this->arrangementdeltagelses[] = $aArrangementdeltagelse;
    if ($aArrangementdeltagelse->indexOfStemme($this) != -1)
    {
      $wasAdded = true;
    }
    else
    {
      $wasAdded = $aArrangementdeltagelse->addStemme($this);
      if (!$wasAdded)
      {
        array_pop($this->arrangementdeltagelses);
      }
    }
    return $wasAdded;
  }

  public function removeArrangementdeltagelse($aArrangementdeltagelse)
  {
    $wasRemoved = false;
    if ($this->indexOfArrangementdeltagelse($aArrangementdeltagelse) == -1)
    {
      return $wasRemoved;
    }

    $oldIndex = $this->indexOfArrangementdeltagelse($aArrangementdeltagelse);
    unset($this->arrangementdeltagelses[$oldIndex]);
    if ($aArrangementdeltagelse->indexOfStemme($this) == -1)
    {
      $wasRemoved = true;
    }
    else
    {
      $wasRemoved = $aArrangementdeltagelse->removeStemme($this);
      if (!$wasRemoved)
      {
        $this->arrangementdeltagelses[$oldIndex] = $aArrangementdeltagelse;
        ksort($this->arrangementdeltagelses);
      }
    }
    $this->arrangementdeltagelses = array_values($this->arrangementdeltagelses);
    return $wasRemoved;
  }

  public function addArrangementdeltagelseAt($aArrangementdeltagelse, $index)
  {  
    $wasAdded = false;
    if($this->addArrangementdeltagelse($aArrangementdeltagelse))
    {
      if($index < 0 ) { $index = 0; }
      if($index > $this->numberOfArrangementdeltagelses()) { $index = $this->numberOfArrangementdeltagelses() - 1; }
      array_splice($this->arrangementdeltagelses, $this->indexOfArrangementdeltagelse($aArrangementdeltagelse), 1);
      array_splice($this->arrangementdeltagelses, $index, 0, array($aArrangementdeltagelse));
      $wasAdded = true;
    }
    return $wasAdded;
  }

  public function addOrMoveArrangementdeltagelseAt($aArrangementdeltagelse, $index)
  {
    $wasAdded = false;
    if($this->indexOfArrangementdeltagelse($aArrangementdeltagelse) !== -1)
    {
      if($index < 0 ) { $index = 0; }
      if($index > $this->numberOfArrangementdeltagelses()) { $index = $this->numberOfArrangementdeltagelses() - 1; }
      array_splice($this->arrangementdeltagelses, $this->indexOfArrangementdeltagelse($aArrangementdeltagelse), 1);
      array_splice($this->arrangementdeltagelses, $index, 0, array($aArrangementdeltagelse));
      $wasAdded = true;
    } 
    else 
    {
      $wasAdded = $this->addArrangementdeltagelseAt($aArrangementdeltagelse, $index);
    }
    return $wasAdded;
  }

  public function equals($compareTo)
  {
    return $this == $compareTo;
  }

  public function delete()
  {
    $copyOfArrangementdeltagelses = $this->arrangementdeltagelses;
    $this->arrangementdeltagelses = array();
    foreach ($copyOfArrangementdeltagelses as $aArrangementdeltagelse)
    {
      $aArrangementdeltagelse->removeStemme($this);
    }
  }

}
?>
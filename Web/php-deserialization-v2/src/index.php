<?php
namespace will\you\call\me {
    class CallMe
    {
        function __call($val, $key)
        {
            return call_user_func($val, ...$key);
        }
    }
}

namespace iam\noone {
    class Noone
    {
        public $woo;
        public $oow;
        public function nobody($cash)
        {
            $this->woo->$cash($this->oow);
        }
    }
}

namespace world\will\call\me {
    class StrongestSorcerer
    {
        private $callMe;
        private $cash = 0;
        public function __tostring()
        {
            if (isset($this->callMe)) {
                if (is_string($this->callMe)) {} else {
                    $this->callMe->nobody($this->cash);
                }
            }
            return "World strongest sorcerer";
        }
    }
}

namespace because\iam\strong\after\all {
    abstract class DomainExpansion
    {
        protected $domain;
        protected $juliet;
    }
}

namespace idwin\really\idwillwin {
    use because\iam\strong\after\all\DomainExpansion;

    class Stringify extends DomainExpansion
    {
        public $romeo;
        private function IamString($s)
        {
            if ($this->juliet == $this->romeo){
                return "$s";
            }
        }
        public function __destruct()
        {
            $this->romeo = random_bytes(100);
            $this->IamString($this->domain);
        }
    }
}

namespace {
    if (isset($_GET['ops']) && isset($_REQUEST['ops'])) {
        if ($_GET['ops'] != $_REQUEST['ops']) {
            unserialize($_REQUEST['ops']);
        }
    }
    highlight_file(__FILE__);
}




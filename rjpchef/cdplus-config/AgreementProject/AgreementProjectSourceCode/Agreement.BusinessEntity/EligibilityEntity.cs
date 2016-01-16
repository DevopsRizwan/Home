/*
Developed by Vasu R
http://www.onlinetrainingdotnet.com
*/
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Agreement.BusinessEntity
{
    public class EligibilityEntity
    {
        public int EligibilityID { get; set; }
        public int AgreementTypeID { get; set; }
        public string FirstName { get; set; }
        public string LastName { get; set; }
        public string SSN { get; set; }
    }
}

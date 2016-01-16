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
    public class StatusEntity
    {
        public int AgreementTypeID { get; set; }
        public int Sno { get; set; }
        public string Item { get; set; }
        public string User { get; set; }
        public string Status { get; set; }
        public string Comments { get; set; }
        public string Actions { get; set; }
        public DateTime ActionDate { get; set; }
       
    }
}

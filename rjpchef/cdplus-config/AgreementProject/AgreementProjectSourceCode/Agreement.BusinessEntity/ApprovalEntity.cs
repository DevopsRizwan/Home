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
    public class ApprovalEntity
    {
        public int? ApprovalID { set; get; }
        public int AgreementTypeID { set; get; }
        public string Comments { set; get; }
        public string Actions { set; get; }
        public string Status { set; get; }
        public string Title { set; get; }
    }
}

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
    public class ApproversEntity
    {
       public int AgreementApproversID{get ; set;}
       public int AgreementTypeID{get ; set;}
       public int? AgreementReviewer { get; set; }
       public int? BusinessReviewer { get; set; }
       public int? LawyerApprover { get; set; }
       public int? OtherApprover { get; set; }

    }
}

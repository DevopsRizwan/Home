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
    public class WorkEntity
    {
        public int WorkID { get; set; }
        public int AgreementTypeID { get; set; }
        public string ServicesProvided { get; set; }
        public string ServiceDescription { get; set; }
        public string GovernmentMarketingServices { get; set; }

        public string Lobbying { get; set; }
        public string NonEmpSalesRepresentation { get; set; }
        public string QuoteDocUniqueName { get; set; }
        public string QuoteDocName { get; set; }
    }
}









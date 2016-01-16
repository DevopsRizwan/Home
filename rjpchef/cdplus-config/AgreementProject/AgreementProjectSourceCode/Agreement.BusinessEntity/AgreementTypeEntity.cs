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
    public class AgreementTypeEntity
    {
        public int AgreementTypeID { get; set; }
        public string AgreementType { get; set; }
        public int BusinessTypeID { get; set; }
        public string Title { get; set; }
        public string WorkType { get; set; }
        public int UserID { get; set; }
        public string BusinessType { get; set; }
        public string Email { get; set; }
        public int VendorID { get; set; }
        public string USTaxIdentificationNo { get; set; }
        public string UNIQUENo { get; set; }
        public string TechnicalInformation { get; set; }
        public string Status { get; set; }
    }

}

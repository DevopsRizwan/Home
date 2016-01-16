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
    public class RegisteredVendorAgreementTypeEntity
    {
        public string RegisteredVendor { get; set; }
        public string StreetAddress { get; set; }
        public string City { get; set; }
        public string State { get; set; }
        public int Zip { get; set; }
        public string Country { get; set; }
        public int PhoneNumber { get; set; }
        public int FaxNumber { get; set; }
        public string ContactName { get; set; }
        public string ContactEmailAddress { get; set; }
        public int USTaxIdentificationNo { get; set; }
        public int UNIQUENo { get; set; }
        public string TechnicalInformation { get; set; }
    }
}

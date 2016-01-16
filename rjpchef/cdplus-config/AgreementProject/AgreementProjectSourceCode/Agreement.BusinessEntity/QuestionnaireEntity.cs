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
   public class QuestionnaireEntity
    {
        public int QuestionID { get; set; }
        public int Sno { get; set; }
        public string Question { get; set; }
        public string AnswerType { get; set; }
        public string Answer { get; set; }
        public int StaffID { get; set; }
    }
}

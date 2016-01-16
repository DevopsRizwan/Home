/*
Developed by Vasu R
http://www.onlinetrainingdotnet.com
*/
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using Agreement.DataAccess;

namespace Agreement.BusinessLogic
{
    public class SubmitBI
    {
        public int Update(int agreementTypeId)
        {
            SubmitDao submit = new SubmitDao();
            return submit.Update(agreementTypeId);
        }
       
    }
}

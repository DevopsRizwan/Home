/*
Developed by Vasu R
http://www.onlinetrainingdotnet.com
*/
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using Agreement.BusinessEntity;
using Agreement.DataAccess;

namespace Agreement.BusinessLogic
{
    public class ApproverBI
    {
        public int Insert(ApproversEntity entity)
        {
            ApproversDao approverDao = new ApproversDao();
             return approverDao.Insert(entity);
        }
        public ApproversEntity Read(int ID)
        {
            ApproversDao approverDao = new ApproversDao();
            return approverDao.Read(ID);
        }

        public void InsertStatus(int approversStatus, int agreementTypeID)
        {

            //logic goes here

            ApproversDao approverDao = new ApproversDao();
            approverDao.InsertStatus(approversStatus, agreementTypeID);
        }
    
    }
}

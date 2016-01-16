/*
Developed by Vasu R
http://www.onlinetrainingdotnet.com
*/
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using Agreement.DataAccess;
using Agreement.BusinessEntity;

namespace Agreement.BusinessLogic
{
    public class ApprovalBI
    {
        public void Insert(ApprovalEntity entity)
        {
            ApprovalDao approvalDao = new ApprovalDao();
            approvalDao.Insert(entity);
        }

        public ApprovalEntity Read(int agreementTypeID,int approvalID)
        {
            ApprovalDao approvalDao = new ApprovalDao();
            return approvalDao.Read(agreementTypeID, approvalID);
        }
    }
}

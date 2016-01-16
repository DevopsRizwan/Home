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
   public class StatusBI
    {
       public List<StatusEntity> ReadList(int agreementTypeID)
       {
           StatusDao UserDao = new StatusDao();
           return UserDao.ReadList(agreementTypeID);
       }
    }
}

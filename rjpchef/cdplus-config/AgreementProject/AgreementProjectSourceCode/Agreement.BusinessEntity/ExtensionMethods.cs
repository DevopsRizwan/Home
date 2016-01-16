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
    public static class ExtensionMethods
    {
        public static DateTime ToDateTime(this object value)
        {
            DateTime parsedVal;

            if (DateTime.TryParse(value.ToStr(), out parsedVal))
                return parsedVal;
            else
                return DateTime.MinValue;
        }

        public static int ToInt32(this object value)
        {
            int parsedVal;

            if (int.TryParse(value.ToStr(), out parsedVal))
                return parsedVal;
            else
                return 0;
        }

        public static string ToStr(this object value)
        {
            if (value == null || value == DBNull.Value)
                return string.Empty;
            else
                return value.ToString();

        }

        public static string ToStr2()
        {
            return "";
        }
    }
}

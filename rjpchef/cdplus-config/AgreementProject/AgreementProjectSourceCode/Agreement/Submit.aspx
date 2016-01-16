<%@ Page Title="" Language="C#" MasterPageFile="~/AgreementMaster.Master" AutoEventWireup="true"
    CodeBehind="Submit.aspx.cs" Inherits="Agreement.Submit" %>

<%@ Register src="Navigator.ascx" tagname="Navigator" tagprefix="uc1" %>

<asp:Content ID="Content1" ContentPlaceHolderID="head" runat="server">
    <script src="Scripts/jquery-1.4.1.min.js" type="text/javascript"></script>
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="contentPlsHldrMainPageTitle" runat="server">
<strong>Submition Page</strong>
</asp:Content>
<asp:Content ID="Content3" ContentPlaceHolderID="contentPlsHldrMain" runat="server">
    <table width="100%">
        <tr>
            <td>
                <uc1:Navigator ID="Navigator1" runat="server" />
            </td>
        </tr>
        <tr>
            <td style="height: 250px; text-align: center;">
                <h3>Agreement Submission</h3><br />
                <asp:CheckBox ID="chkAgreed" runat="server" Text ="I agreed all the terms and conditions."/>
            </td>
        </tr>
        <tr>
            <td style ="text-align :center ;">
                <asp:Button ID="btnPrevious" runat="server" Text="Previous" 
                    onclick="btnPrevious_Click" />&nbsp;<asp:Button ID="btnSubmit"
                    runat="server" Text="Submit" OnClick="btnSubmit_Click" OnClientClick="return validateCheckbox()"/>&nbsp;<asp:Button ID="btnCancel"
                        runat="server" Text="Cancel" onclick="btnCancel_Click" />
            </td>
        </tr>
    </table>
    <script type ="text/javascript">

        function validateCheckbox() {

            if ($('#<%=chkAgreed.ClientID %>').is(':checked') == false) {
                alert('Please check the terms and condition checkbox');
                return false;
            }
            else
                return true;

            //Find the grid (table)
            //Get all tr
            //loop through each tr and Find for the checkbox
            //Check the status checked or not
            //Add the row in an array

            //$('#gridviewid input[type="checkbox"]').is(":checked");
            //alert(document.getElementById('<%=chkAgreed.ClientID %>').checked);
            //alert($('#<%=chkAgreed.ClientID %>').is(':checked'));

           // alert($('#<%=chkAgreed.ClientID %>')[0].checked);
            //filter("is chek";
            //return false;
    }
    </script>
</asp:Content>

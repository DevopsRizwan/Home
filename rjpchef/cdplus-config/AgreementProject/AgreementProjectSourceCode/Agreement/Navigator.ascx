<%@ Control Language="C#" AutoEventWireup="true" CodeBehind="Navigator.ascx.cs" Inherits="Agreement.Navigator" %>
<table width="100%">
    <tr>
        <td>
            <asp:LinkButton Font-Bold ="true" ID="LinkButton1" 
                PostBackUrl="~/AgreementType.aspx" runat="server" onclick="LinkButton1_Click">Agreement</asp:LinkButton>
        </td>
        <td>
            <asp:LinkButton Font-Bold ="true" ID="LinkButton2" PostBackUrl="~/Work.aspx" runat="server">Work</asp:LinkButton>
        </td>
        <td>
            <asp:LinkButton Font-Bold ="true" ID="lnkEligibility" PostBackUrl="~/Eligibility.aspx" runat="server">Eligibility</asp:LinkButton>
        </td>
        <td>
            <asp:LinkButton Font-Bold ="true"  ID="LinkButton4" PostBackUrl="~/Approvers.aspx" runat="server">Approvers</asp:LinkButton>
        </td>
        <td>
            <asp:LinkButton  Font-Bold ="true" ID="LinkButton5" PostBackUrl="~/Submit.aspx" runat="server">Submit</asp:LinkButton>
        </td>
    </tr>
</table>

<%@ Control Language="C#" AutoEventWireup="true" CodeBehind="WorkControl.ascx.cs"
    Inherits="Agreement.UserControls.WorkControl" %>
<%@ Register src="../Navigator.ascx" tagname="Navigator" tagprefix="uc1" %>

<table width="100%" id="tblContainer" runat="server">
    <tr>
        <td colspan="3">
            <uc1:Navigator ID="Navigator1" runat="server" />
        </td>
    </tr>
    <tr>
        <td width="25%">
            Services Provided
        </td>
        <td width="45%">
            <asp:RadioButtonList ID="rdoServicesProvided" runat="server" RepeatDirection="Horizontal">
                <asp:ListItem Value="On" Text="On-Site"></asp:ListItem>
                <asp:ListItem Value="Of" Text="Off-Shore"></asp:ListItem>
                <asp:ListItem Value="Bo" Text="Both"></asp:ListItem>
            </asp:RadioButtonList>
        </td>
        <td width="30%">
            &nbsp;
        </td>
    </tr>
    <tr id="secondrow" runat="server">
        <td>
            Government Marketing Services
        </td>
        <td>
            <asp:RadioButtonList ID="rdoGovernmentMarketingServices" runat="server" RepeatDirection="Horizontal">
                <asp:ListItem Value="Y" Text="Yes"></asp:ListItem>
                <asp:ListItem Value="N" Text="No"></asp:ListItem>
            </asp:RadioButtonList>
        </td>
        <td>
            <asp:RequiredFieldValidator ID="valReqGovernmentMarketingServices" runat="server"
                ControlToValidate="rdoGovernmentMarketingServices" Display="Dynamic" ErrorMessage="Select Government Marketing Services"
                ForeColor="Red" SetFocusOnError="True" ValidationGroup="Next"></asp:RequiredFieldValidator>
        </td>
    </tr>
    <tr>
        <td>
            Service Description
        </td>
        <td>
            <asp:TextBox ID="txtServiceDescription" runat="server" TextMode="MultiLine" Width="361px"></asp:TextBox>
        </td>
        <td>
            <asp:RequiredFieldValidator ID="valReqServicesDescription" runat="server" ControlToValidate="txtServiceDescription"
                Display="Dynamic" ErrorMessage="Enter Services Description" ForeColor="Red" SetFocusOnError="True"
                ValidationGroup="Next"></asp:RequiredFieldValidator>
        </td>
    </tr>
    <tr id="fourthRow" runat="server">
        <td>
            Lobbying
        </td>
        <td>
            <asp:RadioButtonList ID="rdoLobbying" runat="server" RepeatDirection="Horizontal">
                <asp:ListItem Value="Y" Text="Yes"></asp:ListItem>
                <asp:ListItem Value="N" Text="No"></asp:ListItem>
            </asp:RadioButtonList>
        </td>
        <td>
            <asp:RequiredFieldValidator ID="valReqLobbying" runat="server" ControlToValidate="rdoLobbying"
                Display="Dynamic" ErrorMessage="Select Lobbying" ForeColor="Red" SetFocusOnError="True"
                ValidationGroup="Next"></asp:RequiredFieldValidator>
        </td>
    </tr>
    <tr id="fifthRow" runat="server">
        <td>
            Non Employee Sales Representation
        </td>
        <td>
            <asp:RadioButtonList ID="rdoNonEmpSalesRepresentation" runat="server" RepeatDirection="Horizontal">
                <asp:ListItem Value="Y" Text="Yes"></asp:ListItem>
                <asp:ListItem Value="N" Text="No"></asp:ListItem>
            </asp:RadioButtonList>
        </td>
        <td>
            <asp:RequiredFieldValidator ID="valReqNonEmpSalesRepresentation" runat="server" ControlToValidate="rdoNonEmpSalesRepresentation"
                Display="Dynamic" ErrorMessage="Select Non Emp Sales Representation" ForeColor="Red"
                SetFocusOnError="True" ValidationGroup="Next"></asp:RequiredFieldValidator>
        </td>
    </tr>
    <tr id="sixthRow" runat="server">
        <td>
            Upload Quote Information
        </td>
        <td>
            <asp:FileUpload ID="fuQuote" runat="server" />
            <asp:LinkButton ID="lblFileName" runat="server" OnClick="lblFileName_Click"></asp:LinkButton>
            <br />
            <asp:HiddenField ID="hdnFilePath" runat="server" />
            <asp:HiddenField ID="hdnWorkID" runat="server" />
        </td>
        <td>
            <asp:RequiredFieldValidator ID="valReqQuote" runat="server" ControlToValidate="fuQuote"
                Display="Dynamic" ErrorMessage="Upload Quote" ForeColor="Red" SetFocusOnError="True"
                ValidationGroup="Next"></asp:RequiredFieldValidator>
        </td>
    </tr>
    <tr>
        <td>
        </td>
        <td>
            <br />
            <asp:Button ID="btnPrevious" runat="server" OnClick="btnPrevious_Click" Text="Previous" />
            <asp:Button ID="btnSave" Text="Save" runat="server" OnClick="btnSave_Click" />
            &nbsp;&nbsp;<asp:Button ID="btnNext" runat="server" OnClick="btnNext_Click" Text="Next"
                ValidationGroup="Next" />
            &nbsp;<asp:Button ID="btnClear" runat="server" OnClick="btnClear_Click" Text="Cancel" />
        </td>
        <td>
        </td>
    </tr>
</table>



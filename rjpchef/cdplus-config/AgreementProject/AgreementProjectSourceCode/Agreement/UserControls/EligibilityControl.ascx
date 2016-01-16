<%@ Control Language="C#" AutoEventWireup="true" CodeBehind="EligibilityControl.ascx.cs"
    Inherits="Agreement.UserControls.EligibilityControl" %>
<%@ Register Src="../Navigator.ascx" TagName="Navigator" TagPrefix="uc1" %>
<asp:UpdatePanel ID="UpdatePanel1" runat="server">
    <ContentTemplate>
        <table width="100%" id="tblContainer" runat="server">
            <tr>
                <td>
                    <uc1:Navigator ID="Navigator1" runat="server" />
                    <br>
                </td>
            </tr>
            <tr>
                <td align="center">
                    <asp:HiddenField ID="hdnEligibilityID" runat="server" />
                    <asp:GridView ID="gvEligibility" runat="server" AutoGenerateColumns="false" EmptyDataText="No records found."
                        RowStyle-CssClass="rowstyle" OnRowDataBound="gvEligibility_RowDataBound" OnSelectedIndexChanged="gvEligibility_SelectedIndexChanged"
                        OnRowCommand="gvEligibility_RowCommand" align="Center" Width="60%">
                        <Columns>
                            <asp:TemplateField HeaderText="First Name">
                                <ItemTemplate>
                                    <asp:Label ID="lblEligibilityID" runat="server" Text='<%#Eval("EligibilityID") %>'
                                        Visible="false"></asp:Label>
                                    <asp:Label ID="lblFirstName" runat="server" Text='<%#Eval("FirstName") %>'></asp:Label>
                                </ItemTemplate>
                                <HeaderTemplate>
                                    First Name<br />
                                    <asp:TextBox ID="txtFirstName" runat="server"></asp:TextBox>
                                </HeaderTemplate>
                            </asp:TemplateField>
                            <asp:TemplateField HeaderText="Last Name">
                                <ItemTemplate>
                                    <asp:Label ID="lblLastName" runat="server" Text='<%#Eval("LastName") %>'></asp:Label>
                                </ItemTemplate>
                                <HeaderTemplate>
                                    Last Name<br />
                                    <asp:TextBox ID="txtLastName" runat="server"></asp:TextBox>
                                </HeaderTemplate>
                            </asp:TemplateField>
                            <asp:TemplateField HeaderText="SSN">
                                <ItemTemplate>
                                    <asp:Label ID="lblSSN" runat="server" Text='<%#Eval("SSN") %>'></asp:Label>
                                </ItemTemplate>
                                <HeaderTemplate>
                                    SSN<br />
                                    <asp:TextBox ID="txtSSN" runat="server"></asp:TextBox>
                                </HeaderTemplate>
                            </asp:TemplateField>
                            <asp:TemplateField HeaderText="Action" ControlStyle-Height="17px" ControlStyle-Width="17px"
                                HeaderStyle-Width="85px">
                                <ItemTemplate>
                                    <asp:ImageButton ImageUrl="~/images/edit2.png" ID="lnkbtnEdit" runat="server" CommandArgument='<%#Eval("EligibilityID") %>'
                                        CommandName="E"></asp:ImageButton>
                                    &nbsp;&nbsp;
                                    <asp:ImageButton ImageUrl="~/images/delete.png" ID="lnkbtnDelete" runat="server"
                                        CommandName="D" CommandArgument='<%#Eval("EligibilityID") %>' OnClientClick="return DeleteRec();">
                                    </asp:ImageButton>
                                </ItemTemplate>
                                <HeaderTemplate>
                                    Action<br />
                                    <asp:Button ID="btnAdd" runat="server" Text="Add" CommandArgument='<%#Eval("EligibilityID") %>'
                                        CommandName="A" ValidationGroup="Add" />
                                </HeaderTemplate>
                            </asp:TemplateField>
                        </Columns>
                    </asp:GridView>
                </td>
            </tr>
            <tr>
                <td align="center">
                    <asp:TextBox ID="hdnGridRecords" runat="server" Style="display: none;" ValidationGroup="Next" />
                    <asp:RangeValidator ID="valdRangeGridRecs" runat="server" MaximumValue="10000" MinimumValue="1"
                        Type="Integer" ControlToValidate="hdnGridRecords" ErrorMessage="<strong>Please add at least one record.</strong>"
                        ValidationGroup="Next" ForeColor="#FF3300"></asp:RangeValidator>
                </td>
            </tr>
            <tr>
                <td align="center">
                    <asp:Button ID="btnPrevious" Text="Previous" runat="server" OnClick="btnPrevious_Click" />
                    &nbsp
                    <asp:Button ID="btnNext" runat="server" Text="Next" OnClick="btnNext_Click" ValidationGroup="Next" />&nbsp
                    <asp:Button ID="btnCancel" runat="server" Text="Cancel" OnClick="btnCancel_Click" />
                </td>
            </tr>
        </table>
    </ContentTemplate>
</asp:UpdatePanel>
<script type="text/javascript">

    function DeleteRec() {
        return confirm('Are you sure, you want to delete?');
    }
</script>

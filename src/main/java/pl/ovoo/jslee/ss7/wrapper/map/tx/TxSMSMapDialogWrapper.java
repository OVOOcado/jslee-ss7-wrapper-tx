/*
 * JSLEE SS7 Wrapper Tx
 * Copyright (C) 2016-2017 "OVOO Sp. z o.o."
 *
 * This file is part of the JSLEE SS7 Wrapper Tx.
 *
 * JSLEE SS7 Wrapper Tx is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * JSLEE SS7 Wrapper Tx is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package pl.ovoo.jslee.ss7.wrapper.map.tx;

import java.nio.charset.StandardCharsets;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.mobicents.protocols.ss7.map.api.MAPException;
import org.mobicents.protocols.ss7.map.api.primitives.AddressNature;
import org.mobicents.protocols.ss7.map.api.primitives.AddressString;
import org.mobicents.protocols.ss7.map.api.primitives.IMSI;
import org.mobicents.protocols.ss7.map.api.primitives.NumberingPlan;
import org.mobicents.protocols.ss7.map.api.service.lsm.AdditionalNumber;
import org.mobicents.protocols.ss7.map.api.service.sms.LocationInfoWithLMSI;
import org.mobicents.protocols.ss7.map.api.service.sms.MAPDialogSms;
import org.mobicents.protocols.ss7.map.api.service.sms.SM_RP_DA;
import org.mobicents.protocols.ss7.map.api.service.sms.SmsSignalInfo;
import org.mobicents.protocols.ss7.map.api.smstpdu.AbsoluteTimeStamp;
import org.mobicents.protocols.ss7.map.api.smstpdu.AddressField;
import org.mobicents.protocols.ss7.map.api.smstpdu.DataCodingScheme;
import org.mobicents.protocols.ss7.map.api.smstpdu.NumberingPlanIdentification;
import org.mobicents.protocols.ss7.map.api.smstpdu.ProtocolIdentifier;
import org.mobicents.protocols.ss7.map.api.smstpdu.SmsDeliverTpdu;
import org.mobicents.protocols.ss7.map.api.smstpdu.TypeOfNumber;
import org.mobicents.protocols.ss7.map.api.smstpdu.UserData;
import org.mobicents.protocols.ss7.map.api.smstpdu.UserDataHeader;
import org.mobicents.protocols.ss7.map.primitives.AddressStringImpl;
import org.mobicents.protocols.ss7.map.primitives.IMSIImpl;
import org.mobicents.protocols.ss7.map.service.lsm.AdditionalNumberImpl;
import org.mobicents.protocols.ss7.map.service.sms.LocationInfoWithLMSIImpl;
import org.mobicents.protocols.ss7.map.service.sms.SM_RP_DAImpl;
import org.mobicents.protocols.ss7.map.service.sms.SM_RP_OAImpl;
import org.mobicents.protocols.ss7.map.service.sms.SmsSignalInfoImpl;
import org.mobicents.protocols.ss7.map.smstpdu.AbsoluteTimeStampImpl;
import org.mobicents.protocols.ss7.map.smstpdu.AddressFieldImpl;
import org.mobicents.protocols.ss7.map.smstpdu.ConcatenatedShortMessagesIdentifierImpl;
import org.mobicents.protocols.ss7.map.smstpdu.DataCodingSchemeImpl;
import org.mobicents.protocols.ss7.map.smstpdu.ProtocolIdentifierImpl;
import org.mobicents.protocols.ss7.map.smstpdu.SmsDeliverTpduImpl;
import org.mobicents.protocols.ss7.map.smstpdu.UserDataHeaderImpl;
import org.mobicents.protocols.ss7.map.smstpdu.UserDataImpl;
import org.mobicents.slee.resource.map.service.sms.wrappers.MAPDialogSmsWrapper;

import pl.ovoo.jslee.ss7.wrapper.map.tx.args.TxSendRoutingInfoForSMRequestArgWrapper;
import pl.ovoo.jslee.ss7.wrapper.Ss7WrapperException;
import pl.ovoo.jslee.ss7.wrapper.common.tx.TxIMSIAddressWrapper;
import pl.ovoo.jslee.ss7.wrapper.map.SMSMapDialogWrapper;
import pl.ovoo.jslee.ss7.wrapper.map.args.DataCodingWrapper;
import pl.ovoo.jslee.ss7.wrapper.map.args.MtForwardShortMessageRequestWrapper;
import pl.ovoo.jslee.ss7.wrapper.map.args.SendRoutingInfoForSMRequestArgWrapper;
import pl.ovoo.jslee.ss7.wrapper.map.args.SendRoutingInfoForSMResponseWrapper;
import pl.ovoo.jslee.ss7.wrapper.map.args.SmRpUiWrapper;
import pl.ovoo.jslee.ss7.wrapper.map.tx.args.TxMtForwardShortMessageRequestArgWrapper;
import pl.ovoo.jslee.ss7.wrapper.map.tx.args.TxSendRoutingInfoForSMResponseWrapper;


/**
 * Created by karolsimka on 26.06.17.
 */
public class TxSMSMapDialogWrapper  extends TxMapDialogWrapperImpl implements SMSMapDialogWrapper {

    /** The dialog. */
    private MAPDialogSms dialog;

    /**
     * Instantiates a new tx sms map dialog wrapper.
     *
     * @param dialog the dialog
     */
    public TxSMSMapDialogWrapper(final MAPDialogSms dialog) {
        super(dialog);
        this.dialog = dialog;
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.map.SMSMapDialogWrapper#sendSendRoutingInfoForSMRequest(long, pl.ovoo.jslee.ss7.wrapper.map.args.SendRoutingInfoForSMRequestArgWrapper)
     */
    @Override
    public int sendSendRoutingInfoForSMRequest(long sriTimeout, SendRoutingInfoForSMRequestArgWrapper arg) throws Ss7WrapperException {
        try {
            TxSendRoutingInfoForSMRequestArgWrapper txArg = (TxSendRoutingInfoForSMRequestArgWrapper) arg;
            return dialog.addSendRoutingInfoForSMRequest((int) sriTimeout, txArg.getTxMsisdn(),false,txArg.getTxScAddress(),null,false,null,null,null).intValue();
        }catch(MAPException e){
            throw new Ss7WrapperException(e);
        }
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.map.SMSMapDialogWrapper#sendSendRoutingInfoForSMResponse(long, pl.ovoo.jslee.ss7.wrapper.map.args.SendRoutingInfoForSMResponseWrapper)
     */
    @Override
    public void sendSendRoutingInfoForSMResponse(long invoke, SendRoutingInfoForSMResponseWrapper arg) throws Ss7WrapperException {
        try{
            TxSendRoutingInfoForSMResponseWrapper txArg = (TxSendRoutingInfoForSMResponseWrapper) arg;
            TxIMSIAddressWrapper txImsi = null;
            if(txArg.getIMSI()!= null){
                txImsi = (TxIMSIAddressWrapper) txArg.getIMSI();
            }

            LocationInfoWithLMSI lInfo = null;
            if(txArg.getMscAddress()!=null){
                AdditionalNumber an = new AdditionalNumberImpl(txArg.getTxMscAddress(),null);
                lInfo = new LocationInfoWithLMSIImpl(null,null,null,false,an);
            }
            if(txImsi != null)
                ((MAPDialogSmsWrapper) dialog).addSendRoutingInfoForSMResponse(invoke,txImsi.getTxImsi(),lInfo,null,false);
        }catch(MAPException e){
            throw new Ss7WrapperException(e);
        }
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.map.SMSMapDialogWrapper#sendMtForwardSMRequest(long, pl.ovoo.jslee.ss7.wrapper.map.args.MtForwardShortMessageRequestWrapper)
     */
    @Override
    public int sendMtForwardSMRequest(long timeout, MtForwardShortMessageRequestWrapper arg) throws Ss7WrapperException{
        try{
            TxMtForwardShortMessageRequestArgWrapper txArg = (TxMtForwardShortMessageRequestArgWrapper) arg;

            IMSI imsi = new IMSIImpl(txArg.getSm_Rp_Da().getIMSI().getAddress());
            SM_RP_DA sm_rp_da = new SM_RP_DAImpl(imsi);

            SM_RP_OAImpl sm_rp_oa = new SM_RP_OAImpl();
            AddressString aNumber = new AddressStringImpl(AddressNature.international_number, NumberingPlan.ISDN,txArg.getSm_Rp_Oa().getServiceCentreAddressOA().getAddress());
            sm_rp_oa.setServiceCentreAddressOA(aNumber);           
            
            SmRpUiWrapper smRpUi = txArg.getSm_Rp_Ui();
            
            AddressField originatingAddress = new AddressFieldImpl(
            		TypeOfNumber.InternationalNumber, NumberingPlanIdentification.ISDNTelephoneNumberingPlan, smRpUi.getOriginatingAddress());
            Calendar cld = new GregorianCalendar();
            int year = cld.get(Calendar.YEAR);
            int mon = cld.get(Calendar.MONTH);
            int day = cld.get(Calendar.DAY_OF_MONTH);
            int h = cld.get(Calendar.HOUR);
            int m = cld.get(Calendar.MINUTE);
            int s = cld.get(Calendar.SECOND);
            int tz = cld.get(Calendar.ZONE_OFFSET);
            AbsoluteTimeStamp serviceCentreTimeStamp = new AbsoluteTimeStampImpl(year - 2000, mon, day, h, m, s, tz / 1000 / 60 / 15);

            DataCodingScheme dcs = new DataCodingSchemeImpl(smRpUi.getCharset().getValue());
            
            boolean is16bit = smRpUi.getCharset() == DataCodingWrapper.UCS2 ? true : false;
            UserDataHeader udh = new UserDataHeaderImpl();
            if(smRpUi.getIsConcatened()){
            	udh.addInformationElement(new ConcatenatedShortMessagesIdentifierImpl(is16bit, smRpUi.getMessageRef(),
            			smRpUi.getSegmCnt(), smRpUi.getSegmNum()));
            }
            
            UserData userData;
            if(smRpUi.getCharset() == DataCodingWrapper.UCS2) {
                userData = new UserDataImpl(smRpUi.getText(), dcs, udh, StandardCharsets.UTF_16BE);
            }else{
                userData = new UserDataImpl(smRpUi.getText(), dcs, udh, StandardCharsets.UTF_8);
            }
            ProtocolIdentifier pi = new ProtocolIdentifierImpl(0);
            SmsDeliverTpdu tpdu = new SmsDeliverTpduImpl(smRpUi.getMoreMessagesToSend(), false, false, false, originatingAddress, pi, serviceCentreTimeStamp, userData);
            SmsSignalInfo si = new SmsSignalInfoImpl(tpdu, null);

            return dialog.addMtForwardShortMessageRequest((int)timeout,sm_rp_da,sm_rp_oa,si,false,null).intValue();
        }catch(MAPException e){
            throw new Ss7WrapperException(e);
        }
    }
}

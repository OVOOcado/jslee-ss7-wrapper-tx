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

package pl.ovoo.jslee.ss7.wrapper.cap.tx.event;

import org.mobicents.protocols.ss7.cap.api.service.circuitSwitchedCall.InitialDPRequest;
import pl.ovoo.jslee.ss7.wrapper.cap.args.InitialDPArgWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.event.InitialDPRequestEventWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.tx.args.cap1.TxCap1InitialDPArgWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.tx.args.cap2.TxCap2InitialDPArgWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.tx.args.cap3.TxCap3InitialDPArgWrapper;

import javax.slee.ActivityContextInterface;

/**
 * TxInitialDPRequestEventWrapper
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxInitialDPRequestEventWrapper extends TxEventWrapper implements InitialDPRequestEventWrapper {

    private final InitialDPRequest initialDPRequest;

    public TxInitialDPRequestEventWrapper(final InitialDPRequest initialDPRequest, final ActivityContextInterface aci) {
        super(aci, initialDPRequest);
        this.initialDPRequest = initialDPRequest;
    }

    @Override
    public InitialDPArgWrapper getArgument() {
        final TxCap1InitialDPArgWrapper txCap1InitialDPArgWrapper;
        switch (getTxDialog().getApplicationContext()) {
            case CapV1_gsmSSF_to_gsmSCF:
                txCap1InitialDPArgWrapper= new TxCap1InitialDPArgWrapper();
                break;
            case CapV2_gsmSRF_to_gsmSCF:
            case CapV2_assistGsmSSF_to_gsmSCF:
            case CapV2_gsmSSF_to_gsmSCF:
                txCap1InitialDPArgWrapper = new TxCap2InitialDPArgWrapper();
                break;
            case CapV3_cap3_sms:
            case CapV3_gprsSSF_gsmSCF:
            case CapV3_gsmSCF_gprsSSF:
            case CapV3_gsmSRF_gsmSCF:
            case CapV3_gsmSSF_scfAssistHandoff:
            case CapV3_gsmSSF_scfGeneric:
                txCap1InitialDPArgWrapper = new TxCap3InitialDPArgWrapper();
                break;
            default:
                txCap1InitialDPArgWrapper = new TxCap3InitialDPArgWrapper();
        }
        txCap1InitialDPArgWrapper.setTxBearerCapability(initialDPRequest.getBearerCapability());
        txCap1InitialDPArgWrapper.setTxCalledPartyNumber(initialDPRequest.getCalledPartyNumber());
        txCap1InitialDPArgWrapper.setTxCallingPartyNumber(initialDPRequest.getCallingPartyNumber());
        txCap1InitialDPArgWrapper.setTxEventTypeBCSM(initialDPRequest.getEventTypeBCSM());
        txCap1InitialDPArgWrapper.setTxHighLayerCompatibility(initialDPRequest.getHighLayerCompatibility());
        txCap1InitialDPArgWrapper.setTxRedirectingPartyID(initialDPRequest.getRedirectingPartyID());
        txCap1InitialDPArgWrapper.setTxRedirectionInformationInap(initialDPRequest.getRedirectionInformation());
        txCap1InitialDPArgWrapper.setTxOriginalCalledPartyID(initialDPRequest.getOriginalCalledPartyID());
        txCap1InitialDPArgWrapper.setTxCallingPartysCategoryInap(initialDPRequest.getCallingPartysCategory());
        txCap1InitialDPArgWrapper.setServiceKey(initialDPRequest.getServiceKey());

        txCap1InitialDPArgWrapper.setTxCalledPartyBCDNumber(initialDPRequest.getCalledPartyBCDNumber());
        txCap1InitialDPArgWrapper.setTxCallReferenceNumber(initialDPRequest.getCallReferenceNumber());
        txCap1InitialDPArgWrapper.setTxExtBasicServiceCode(initialDPRequest.getExtBasicServiceCode());
        txCap1InitialDPArgWrapper.setTxImsi(initialDPRequest.getIMSI());
        txCap1InitialDPArgWrapper.setTxLocationInformation(initialDPRequest.getLocationInformation());
        txCap1InitialDPArgWrapper.setTxMscAddress(initialDPRequest.getMscAddress());

        if (txCap1InitialDPArgWrapper instanceof TxCap2InitialDPArgWrapper) {
            ((TxCap2InitialDPArgWrapper) txCap1InitialDPArgWrapper).setTxTimeAndTimezone(initialDPRequest.getTimeAndTimezone());
        }
        return txCap1InitialDPArgWrapper;
    }
}

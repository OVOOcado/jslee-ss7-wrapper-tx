/*
 * SS7 Wrapper
 * Copyright (C) 2016-2017 "OVOO Sp. z o.o."
 *
 * This file is part of the SS7 Wrapper.
 *
 */

package pl.ovoo.ss7.wrapper.cap.telestax.event;

import org.mobicents.protocols.ss7.cap.api.service.circuitSwitchedCall.PlayAnnouncementRequest;
import pl.ovoo.ss7.wrapper.Ss7WrapperException;
import pl.ovoo.ss7.wrapper.cap.args.PlayAnnouncementArgWrapper;
import pl.ovoo.ss7.wrapper.cap.event.PlayAnnouncementRequestEventWrapper;
import pl.ovoo.ss7.wrapper.cap.telestax.args.TxPlayAnnouncementArgWrapper;

import javax.slee.ActivityContextInterface;

/**
 * TxPlayAnnouncementRequestEventWrapper
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxPlayAnnouncementRequestEventWrapper extends TxEventWrapper implements PlayAnnouncementRequestEventWrapper {

    private final PlayAnnouncementRequest playAnnouncementRequest;

    public TxPlayAnnouncementRequestEventWrapper(final PlayAnnouncementRequest playAnnouncementRequest, final ActivityContextInterface aci) {
        super(aci, playAnnouncementRequest);
        this.playAnnouncementRequest = playAnnouncementRequest;
    }

    @Override
    public PlayAnnouncementArgWrapper getArgument() throws Ss7WrapperException {
        final TxPlayAnnouncementArgWrapper playAnnouncementArgWrapper;
        switch (getTxDialog().getApplicationContext()) {
            case CapV1_gsmSSF_to_gsmSCF:
                playAnnouncementArgWrapper = new TxPlayAnnouncementArgWrapper();
                break;
            case CapV2_assistGsmSSF_to_gsmSCF:
            case CapV2_gsmSRF_to_gsmSCF:
            case CapV2_gsmSSF_to_gsmSCF:
                playAnnouncementArgWrapper = new TxPlayAnnouncementArgWrapper();
                break;
            default:
                playAnnouncementArgWrapper = new TxPlayAnnouncementArgWrapper();
        }
        playAnnouncementArgWrapper.setTxInformationToSend(playAnnouncementRequest.getInformationToSend());
        playAnnouncementArgWrapper.setTxRequestAnnouncementComplete(playAnnouncementRequest.getRequestAnnouncementCompleteNotification());
        return playAnnouncementArgWrapper;
    }
}

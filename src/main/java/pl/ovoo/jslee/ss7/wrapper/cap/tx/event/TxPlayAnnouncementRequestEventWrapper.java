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

import org.mobicents.protocols.ss7.cap.api.service.circuitSwitchedCall.PlayAnnouncementRequest;
import pl.ovoo.jslee.ss7.wrapper.cap.tx.args.TxPlayAnnouncementArgWrapper;
import pl.ovoo.jslee.ss7.wrapper.Ss7WrapperException;
import pl.ovoo.jslee.ss7.wrapper.cap.args.PlayAnnouncementArgWrapper;
import pl.ovoo.jslee.ss7.wrapper.cap.event.PlayAnnouncementRequestEventWrapper;

import javax.slee.ActivityContextInterface;


/**
 * TxPlayAnnouncementRequestEventWrapper.
 *
 * @author pawel.borecki@ovoo.pl
 */
public class TxPlayAnnouncementRequestEventWrapper extends TxEventWrapper implements PlayAnnouncementRequestEventWrapper {

    /** The play announcement request. */
    private final PlayAnnouncementRequest playAnnouncementRequest;

    /**
     * Instantiates a new tx play announcement request event wrapper.
     *
     * @param playAnnouncementRequest the play announcement request
     * @param aci the aci
     */
    public TxPlayAnnouncementRequestEventWrapper(final PlayAnnouncementRequest playAnnouncementRequest, final ActivityContextInterface aci) {
        super(aci, playAnnouncementRequest);
        this.playAnnouncementRequest = playAnnouncementRequest;
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.cap.event.ArgumentEventWrapper#getArgument()
     */
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

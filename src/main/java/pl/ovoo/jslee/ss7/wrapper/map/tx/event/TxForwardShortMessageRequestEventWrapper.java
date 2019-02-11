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

package pl.ovoo.jslee.ss7.wrapper.map.tx.event;

import javax.slee.ActivityContextInterface;

import org.mobicents.protocols.ss7.map.api.service.sms.ForwardShortMessageRequest;
import org.mobicents.protocols.ss7.map.primitives.ISDNAddressStringImpl;

import pl.ovoo.jslee.ss7.wrapper.common.tx.TxIMSIAddressWrapper;
import pl.ovoo.jslee.ss7.wrapper.map.tx.args.TxSmRpDaWrapper;
import pl.ovoo.jslee.ss7.wrapper.map.args.DataCodingWrapper;
import pl.ovoo.jslee.ss7.wrapper.map.args.ForwardShortMessageRequestWrapper;
import pl.ovoo.jslee.ss7.wrapper.map.event.ForwardShortMessageRequestEventWrapper;
import pl.ovoo.jslee.ss7.wrapper.map.tx.args.TxForwardShortMessageRequestArgWrapper;
import pl.ovoo.jslee.ss7.wrapper.map.tx.args.TxSmRpOaWrapper;
import pl.ovoo.jslee.ss7.wrapper.map.tx.args.TxSmRpUiWrapper;


/**
 * Created by karolsimka on 08.06.17.
 */
public class TxForwardShortMessageRequestEventWrapper extends TxMapEventWrapper implements ForwardShortMessageRequestEventWrapper {

    /** The forward short message request. */
    private final ForwardShortMessageRequest forwardShortMessageRequest;

    /**
     * Instantiates a new tx forward short message request event wrapper.
     *
     * @param forwardShortMessageRequest the forward short message request
     * @param aci the aci
     */
    public TxForwardShortMessageRequestEventWrapper(final ForwardShortMessageRequest forwardShortMessageRequest, final ActivityContextInterface aci) {
        super(aci);
        this.forwardShortMessageRequest = forwardShortMessageRequest;
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.map.event.MtForwardShortMessageRequestEventWrapper#getArgument()
     */
    @Override
    public ForwardShortMessageRequestWrapper getArgument() {
        TxForwardShortMessageRequestArgWrapper txForwardShortMessageRequestArgWrapper = new TxForwardShortMessageRequestArgWrapper();

        TxSmRpDaWrapper sm_rp_da = new TxSmRpDaWrapper();
        sm_rp_da.setIMSI(new TxIMSIAddressWrapper(forwardShortMessageRequest.getSM_RP_DA().getIMSI()));
        txForwardShortMessageRequestArgWrapper.setSm_Rp_Da(sm_rp_da);

        TxSmRpOaWrapper sm_rp_oa = new TxSmRpOaWrapper();
        sm_rp_oa.setTxServiceCentreAddressOa(new ISDNAddressStringImpl(forwardShortMessageRequest.getSM_RP_OA().getServiceCentreAddressOA().getAddressNature(),forwardShortMessageRequest.getSM_RP_OA().getServiceCentreAddressOA().getNumberingPlan(),forwardShortMessageRequest.getSM_RP_OA().getServiceCentreAddressOA().getAddress()));
        txForwardShortMessageRequestArgWrapper.setSm_Rp_Oa(sm_rp_oa);

        TxSmRpUiWrapper sm_rp_ui = new TxSmRpUiWrapper();
        sm_rp_ui.setData(forwardShortMessageRequest.getSM_RP_UI().getData());
        sm_rp_ui.setCharset(DataCodingWrapper.lookup(forwardShortMessageRequest.getSM_RP_UI().getGsm8Charset().name()));
        
        txForwardShortMessageRequestArgWrapper.setSm_Rp_Ui(sm_rp_ui);

        return txForwardShortMessageRequestArgWrapper;
    }

    /* (non-Javadoc)
     * @see pl.ovoo.jslee.ss7.wrapper.map.event.MapEventWrapper#getInvokeId()
     */
    @Override
    public long getInvokeId() {
        return forwardShortMessageRequest.getInvokeId();
    }
}

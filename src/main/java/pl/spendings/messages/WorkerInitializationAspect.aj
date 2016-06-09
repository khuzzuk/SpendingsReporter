package pl.spendings.messages;


privileged public aspect WorkerInitializationAspect {
    after(Channel channel): execution(pl.spendings.messages.Channel.new()) && this(channel){
        channel.init();
    }
}

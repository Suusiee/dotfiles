# ~/.bashrc

export PATH=$HOME/usr/bin:$PATH

export JAVA_HOME=/Library/Java/Home
export JAVA_OPTS="-server -Xms128m -Xmx1024m -XX:MaxPermSize=256m"
export CLASSPATH=.

export ANT_HOME=$HOME/usr/ant

export BLOCKSIZE=K
export PAGER='less'

alias ls='ls -AFGl'
alias dir='\ls -AFG'
alias cpl='clear; pwd; ls'

alias cp='cp -i'
alias mv='mv -i'
alias rm='rm -i'

alias h='history'
alias ..='cd ..'

alias gvim='gvim -reverse'

PS1='\h:\w$(__git_ps1 " [%s]")\$ '

HISTIGNORE="ls:pwd:w:ps:jobs:bg:fg:clear:exit"
HISTCONTROL=ignoredups
HISTFILESIZE=2000
HISTSIZE=200

# append to the history file, don't overwrite it
shopt -s histappend

umask 0077

mesg n

# Git tab completion
GTC='/usr/local/git/contrib/completion/git-completion.bash'
[ -r $GTC ] && . $GTC 
